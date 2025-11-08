package org.pm.looscoupling.main;

import org.pm.looscoupling.services.Fedx;
import org.pm.looscoupling.services.IDeliveryService;

public class Amazon {

    private IDeliveryService service;

    public Amazon(IDeliveryService service){
        this.service = service;
    }

    public Boolean deliverTheProuct(int price){
//        Fedx fedx = new Fedx();
//        fedx.deliveryProduct(price);
       return service.deliveryProduct(price);
    }
}
