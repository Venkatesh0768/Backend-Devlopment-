package org.pm.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationconfig.xml");
        Empolyee  empolyee = applicationContext.getBean( "empolyee" , Empolyee.class);
        Empolyee  empolyee1 = applicationContext.getBean( "empolyee2" , Empolyee.class);
        Empolyee  empolyee2 = applicationContext.getBean( "empolyee3" , Empolyee.class);
        System.out.println(empolyee);
        System.out.println(empolyee1);
        System.out.println(empolyee2);
    }
}
