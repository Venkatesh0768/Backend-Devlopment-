package org.pm.main;

import org.pm.services.Java;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


public class LaunchApp {
    public static void main(String[] args) {

        ApplicationContext container =
                new ClassPathXmlApplicationContext("applicationconfig.xml");


        Venky v = container.getBean(Venky.class);
        v.buyTheCourse(400.00);
    }
}
