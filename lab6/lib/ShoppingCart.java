package lib;

import java.util.ArrayList;


public class ShoppingCart {
     private ArrayList<CartItem> cartItem = new ArrayList<>();
     private ProductCatalog productCatalog;
     private PricingService pricingService;

    // Rep Invariant (RI)
    //  - ArrayList
    //  - quantity > 0
    //
    // Abstration Function (AF)
    //  - AF(product, quantity) = An item in a shopping cart
    //    with the specified quantity

    /**
     * ตรวจสอบ Rep Invariant เป็นจริงหรือไม่
     * 
     */

     public void checkRep(){
        if (cartItem == null) {
            throw new RuntimeException("RI violated : cartItem cannot be null");
        }
        for(int i = 0; i < cartItem.size(); i++){
            CartItem itemi = cartItem.get(i);
            if (itemi == null) {
                throw new RuntimeException("RI violated: CartItem must not be null");
            }

            

        for(int j = i + 1; j < cartItem.size(); j++){
            CartItem itemJ = cartItem.get(j);
            if (itemi.getproduct().getproductId().equals(itemJ.getproduct().getproductId())) {
                throw new RuntimeException("RI violated: duplicate product in cart");
            }
        }
    }
        
        
}
    
     public ShoppingCart(ProductCatalog productCatalog, PricingService pricingService){
        this.productCatalog = productCatalog;
        this.pricingService = pricingService;
        checkRep();
     }

     public void addItem(String productId, int quantity){
        Product product = productCatalog.findById(productId);

        if (quantity <= 0) {
        throw new IllegalArgumentException("Quantity must be > 0");
        }
        
        if (product == null) {
            throw new IllegalArgumentException("Product not found: " + productId );
        }

        for (CartItem item : cartItem) {
            if (item.getproduct().getproductId().equals(productId)) {
                item.increaseQuatity(quantity);
                checkRep();
                return;
            }
        }
        cartItem.add(new CartItem(product, quantity));
        checkRep();
     }

     public void removeItem(String productId){
        for(int i = 0; i < cartItem.size(); i++){
            if (cartItem.get(i).getproduct().getproductId().equals(productId)) {
                cartItem.remove(i);
                checkRep();
                return;
            }
        }
     }

     public double getTotalPrice(){
        double total = 0.0;
        for (CartItem item : cartItem) {
            total += pricingService.calculateItemPrice(item);
        }
        return total;
     }

     public int getItemCount(){
        return cartItem.size();
     }
     public void clearCart(){
        cartItem.clear();
        checkRep();
     }
}
