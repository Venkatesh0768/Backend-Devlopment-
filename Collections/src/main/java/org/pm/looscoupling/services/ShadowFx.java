package org.pm.looscoupling.services;

public class ShadowFx  implements IDeliveryService{
    @Override
    public Boolean deliveryProduct(int price) {
        System.out.println("ShadowFX Delivery the Product "+ price);
        return true;
    }
}
