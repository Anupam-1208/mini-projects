package org.example;

public class JustInTimeStrategy implements ReplenishmentStrategy{
    @Override
    public void replenish(Product product) {
        System.out.println("Applying Just In-time replenishmet to:" + product.getName());
        product.setQuantity(product.getQuantity() + 10);
    }
}
