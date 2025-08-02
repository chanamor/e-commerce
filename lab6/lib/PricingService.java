package lib;

import java.util.ArrayList;

import lib.discount.DefaultPricingStrategy;

public class PricingService {
    private record StrategyRule(String sku, DiscountStrategy strategy) {}
    private final ArrayList<StrategyRule> strategies = new ArrayList<>();
    private final DiscountStrategy defaulStrategy = new DefaultPricingStrategy();


    /**
     * 
     * ลงทะเบียนกลยุทธ์ส่วนลดสำหรับสินค้า sku ที่กำหนด
     * หากมี promotion sku
     * @param sku รหัสสินค้าที่ต้องการกับ promotion
     * @param strategy กลยุทธ์ส่วนลดที่จะใช้
     * 
     */

     public void addStrategy(String sku, DiscountStrategy strategy){
        StrategyRule ruleToRemove = null;

        for (StrategyRule rule : strategies) {
            if (rule.sku().equals(sku)) {
                ruleToRemove = rule;
                break;
            }
        }
        if (ruleToRemove != null) {
            strategies.remove(ruleToRemove);
        }

        strategies.add(new StrategyRule(sku, strategy));
     }



     public double calculateItemPrice(CartItem item){
        String sku = item.getproduct().getproductId();
        for (StrategyRule rule : strategies) {
            if (rule.sku().equals(sku)) {
                return rule.strategy().calculatePrice(item);

            }
        }
        return defaulStrategy.calculatePrice(item);
        
     }
    }

