package lib;

public class CartItem {
    private final Product product;
    private int quantity;

    // Rep Invariant (RI)
    //  - productId and productName  are not null or blank
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
        if (product == null) {
            throw new RuntimeException("RI violated : product cannot use");
        }
        if (quantity < 0) {
            throw new RuntimeException("RI violated : quantity cannot use");
        }
    }

    public CartItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
        checkRep();
    }

    public Product getproduct(){return product;}
    public int getquantity(){return quantity;}

    /**
     * 
     * 
     * 
     * @param amount จำนวนที่ต้องการเพิ่ม
     * 
     */

     public void increaseQuantity(int amount){
        if (amount < 0) {
            throw new RuntimeException("RI violated : amount cannot use");
        }
        this.quantity += amount;
        checkRep();
     }
}
