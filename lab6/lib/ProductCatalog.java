package lib;

import java.util.ArrayList;

public class ProductCatalog {
    private ArrayList<Product> products = new ArrayList<>();

    //RI product list != null and no duplicate product
    //AF = A catalog of all avalible products.

    private void checkRep(){
        if (products == null) {
            throw new RuntimeException("RI violated : product cannot use");
        }

        // เช็ค ตัวซ้ำ
        for(int i = 0; i < products.size(); i++){
            for(int j = 0; j < products.size(); j++){
                if (products.get(i) == products.get(j)) {
                    throw new RuntimeException("RI violated : product cannot use : duplicate");
                }
            }
        }
    }

    public ProductCatalog(){
        checkRep();
    }
    
    /**
     * 
     * เพิ่มสินค้าใหม่เข้า catolog
     * 
     *  @param product สินค้าที่จะเพิ่ม
     */
    public void addProduct(Product product){
        if (product != null && !products.contains(product)) {
            products.add(product);
        }
    }

    /**
     * 
     * 
     * 
     * @param productId รหัสสิค้าที่ต้องการหา 
     * @return obj product 
     */
    public Product findById(String productId){
        for (Product p : products) {
            if (p.getproductId().equals(productId)) {
                return p;
            }
            
        }
        return null;
    }
}
