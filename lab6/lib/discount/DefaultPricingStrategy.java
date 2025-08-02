package lib.discount;

import lib.*;

public class DefaultPricingStrategy implements DiscountStrategy {

    @Override
    public double calculatePrice(CartItem item) {
        
        return item.getquantity() * item.getproduct().getprice();
    }
    
}
