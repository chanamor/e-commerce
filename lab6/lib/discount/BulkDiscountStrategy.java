package lib.discount;

import lib.*;

/**
 * 
 *  Bulk 
 * 
 * 
 */

public class BulkDiscountStrategy implements DiscountStrategy {
    private int minimumQuantity;
    private double discountPercentage;


    public BulkDiscountStrategy(int minimumQuantity, double discountPercentage){
            this.minimumQuantity = minimumQuantity;
            this.discountPercentage = discountPercentage;
        }


    @Override
    
    public double calculatePrice(CartItem item) {
        int quantity = item.getquantity();
        double price = item.getproduct().getprice();

        if (quantity >= minimumQuantity) {
            return price * quantity * discountPercentage;
        }else{
            return 0.0;
        }
        
       
    }
    
}
