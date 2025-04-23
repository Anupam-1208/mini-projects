package org.example;

public class SupplierNotifier implements InventoryObserver{
    @Override
    public void update(Product product) {
        System.out.println("Notifying the ");
    }
}
