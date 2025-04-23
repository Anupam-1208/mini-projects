package org.example;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    int id;
    String name;
    String location;
    Map<String, Product> products;

    public Warehouse(int id, String name, String location){
        this.id = id;
        this.name = name;
        this.location = location;
        products = new HashMap<>();
    }

    public void addProduct(Product product, int quantity){
        String sku = product.getSku();
        if(products.containsKey(sku)){
            products.get(sku).setQuantity(quantity);
        } else {
            product.setQuantity(quantity);
            products.put(sku,product);
        }
        System.out.println(quantity + " units of " + product.getName()
                + " (SKU: " + sku + ") added to " + name
                + ". New quantity: " + product.getQuantity());

    }
    public Product getProductBySku(String sku){
        return products.get(sku);
    }

}
