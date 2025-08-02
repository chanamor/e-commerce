package lib.discount;

import lib.*;
/**
 * 
 * Bogo ซื้อ 1 free 1
 * 
 */

public class BogoDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculatePrice(CartItem item) {
        int quantity = item.getquantity();
        double price = item.getproduct().getprice();
        int quantityTopay = (quantity/2)+(quantity %2);
        return price * quantityTopay;
        
    }
    
}
