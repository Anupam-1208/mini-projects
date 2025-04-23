package org.example;

public class ProductFactory {
    public Product createNewProduct(ProductCategory category, int threshold, String sku, String name, double price, int quantity){
        switch (category) {
            case ELECTRONICS -> {
                return new ElectronicsProduct(sku, name, price, quantity, category, threshold);
            }
            case GROCERY -> {
                return new GroceryProduct(sku, name, price, quantity, threshold);
            }
            default -> {
                throw new IllegalArgumentException("Unsupported product details");
            }
        }
    }
}
