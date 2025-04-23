package org.example;

public class ElectronicsProduct extends Product{
    private String brand;
    private int warrantyPeriod;

    public ElectronicsProduct(String sku, String name, double price, int quantity, ProductCategory category, int threshold) {
        super();
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setThreshold(threshold);
        setSku(sku);
        setCategory(ProductCategory.ELECTRONICS);
    }

    public String getBrand() {
        return brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
}
