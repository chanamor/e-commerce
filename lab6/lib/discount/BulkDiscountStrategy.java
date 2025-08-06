package lib.discount;

import lib.*;

/**
 * 
 *  Bulk 
 * -ให้ส่วนลดเป็นเปอร์เซ็นต์ถ้าซื้อสินค้าเกินจำนวนขั้นต่ำ
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
            return price * quantity * ( 1 - discountPercentage);
        }else{
            return price * quantity;
        }
        
       
    }
    
}
