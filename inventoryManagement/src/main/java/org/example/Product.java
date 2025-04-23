package org.example;

public abstract class Product {
    private String sku;
    private String name;
    private double price;
    private int quantity;
    private int threshold;
    ProductCategory category;

//    public Product(String sku, String name, double price, int quantity, ProductCategory category, int threshold){
//        this.sku = sku;
//        this.name = name;
//        this.price = price;
//        this.quantity = quantity;
//        this.threshold = threshold;
//        this.category = category;
//
//    }
//
    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}
