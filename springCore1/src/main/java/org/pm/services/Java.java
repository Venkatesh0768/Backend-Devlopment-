package org.pm.services;

public class Java implements ICourse{

    public Java(){
        System.out.println("Java Bean is Created");
    }
    @Override
    public Boolean getTheCourse(Double amount) {
        System.out.println("Java Course is Purchased "+ amount);
        return true;
    }
}
