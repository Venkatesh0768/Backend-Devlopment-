package org.pm.looscoupling.main;

import org.pm.looscoupling.services.Ekart;
import org.pm.looscoupling.services.Fedx;
import org.pm.looscoupling.services.ShadowFx;

public class LaunchAmazon {

    public static void main(String[] args) {
        Amazon amazon = new Amazon(new ShadowFx());
        System.out.println( amazon.deliverTheProuct(233));

    }
}
