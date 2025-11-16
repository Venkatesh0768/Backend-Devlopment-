package org.pm.springdatajpa;

import org.pm.springdatajpa.model.User;
import org.pm.springdatajpa.service.UserService;
import org.pm.springdatajpa.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(SpringDataJpaApplication.class, args);
        UserServiceImpl service  = container.getBean(UserServiceImpl.class);
        service.registerUser(new User(6 , "Venky"));
        List<User>  list = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            list.add(new User(i , "Nve"));
        }
        service.registerMultipleUser(list);
    }

}
