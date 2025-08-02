package lib;

public final class Product {
    private final String productID;
    private final String productName;
    private final double price;

    // Rep Invariant (RI)
    //  - productId and productName  are not null or blank
    //  - price >= 0 
    //
    // Abstration Function (AF)
    //  - AF(productId, productName, price) = A product with the given

    /**
     * ตรวจสอบ Rep invariant เป็นจริงหรือไม่
     */

     private void checkRep(){
        if (productID == null || productID.isBlank()) {
            throw new RuntimeException("RI violated : productId cannot use");
        }
        if (productName == null || productName.isBlank()) {
            throw new RuntimeException("RI violated : productName cannot use");
        }
        if (price < 0) {
            throw new RuntimeException("RI violated : price cannot use");
        }
     }

     public Product(String productId, String productName, double price){
        this.productID = productId;
        this.productName = productName;
        this.price = price;
        checkRep();
     }

     public String getproductId(){return productID;}
     public String getproductName(){return productName;}
     public double getprice(){return price;}

     /**
      * เปรียบเทียบ product สองชิ้นขึ้นโดยใช้ productId
      * @param obj อ็อปเจกที่ต้องการเปรียบเทียบ
      * @return ture หาก productId เหมือนกัน
      */

      @Override
      public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (this == null || getClass() != obj.getClass()) {
            return false;
        }
        return false;
      }

    
     
      
}
