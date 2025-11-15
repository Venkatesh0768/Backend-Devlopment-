package org.pm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new  ClassPathXmlApplicationContext("applicationconfig1.xml");

    }
}
