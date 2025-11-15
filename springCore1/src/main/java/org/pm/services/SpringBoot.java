package org.pm.services;

public class SpringBoot implements ICourse{
    public SpringBoot(){
        System.out.println("Spring Boot Bean is Created");
    }
    @Override
    public Boolean getTheCourse(Double amount) {
        System.out.println("Spring Boot Course is Purchased "+ amount);
        return true;
    }
}
