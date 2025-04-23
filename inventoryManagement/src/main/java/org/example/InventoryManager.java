package org.example;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private static InventoryManager instance;

    private List<Warehouse> warehouses;
    private ProductFactory productFactory;
    private ReplenishmentStrategy replenishmentStrategy;
    private List<InventoryObserver> observers;

    private InventoryManager(){
        warehouses = new ArrayList<>();
        productFactory = new ProductFactory();
    }

    public static synchronized InventoryManager getInstance(){
        if(instance == null){
            instance = new InventoryManager();
        }
        return instance;
    }

    public void setReplenishmentStrategy(ReplenishmentStrategy strategy){
        this.replenishmentStrategy = strategy;
    }
    public void addWarehouse(Warehouse warehouse){
        warehouses.add(warehouse);
    }

    public Product getProductBySku(String sku){
        for(Warehouse warehouse: warehouses){
            Product product = warehouse.getProductBySku(sku);
            if (product != null){
                return product;
            }
        }
        return null;
    }

    public void notifyObservers(Product product){
        observers.stream().map(observer -> observer.update(product));
    }

    public void checkAndReplenish(String sku){
        Product product =  getProductBySku(sku);
        if(product != null){
            if(product.getQuantity() < product.getThreshold()){
                notifyObservers(product);
                if (replenishmentStrategy != null){
                    replenishmentStrategy.replenish(product);
                }
            }
        }else {
            System.out.println(" no product found with the given sku");
        }
    }

    public void performInventoryCheck(){
        warehouses.stream().map( warehouse -> {
            return warehouse.products.values().stream().map( product -> {
                if (product.getQuantity() < product.getThreshold()){
                    notifyObservers(product);
                    if (replenishmentStrategy != null){
                        replenishmentStrategy.replenish(product);
                    }
                }
                return null;
            });
        });
    }
}
