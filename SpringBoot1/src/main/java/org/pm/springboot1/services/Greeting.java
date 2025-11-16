package org.pm.springboot1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class Greeting {

    @Autowired
    private LocalDate localDate;


    public Greeting(){
        System.out.println("This is the bean of the greeting ");
    }

    public String generateWish(){
        return  localDate.toString();
    }

}
