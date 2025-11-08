package org.pm.looscoupling.services;

public class Ekart implements IDeliveryService{
    @Override
    public Boolean deliveryProduct(int price) {
        System.out.println("Ekart Delivery the Product "+ price);
        return true;
    }
}
