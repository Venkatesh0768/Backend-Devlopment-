package org.pm.springboot1;

import org.pm.springboot1.services.Greeting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBoot1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(SpringBoot1Application.class, args);
        Greeting greeting = container.getBean(Greeting.class);
        System.out.println(  greeting.generateWish());
        container.close();


    }

}
