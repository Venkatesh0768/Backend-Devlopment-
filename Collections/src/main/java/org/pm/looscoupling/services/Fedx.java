package org.pm.looscoupling.services;

public class Fedx implements IDeliveryService {

    @Override
    public Boolean deliveryProduct(int price) {
        System.out.println("Fedx Delivery the Product "+ price);
        return true;
    }
}
