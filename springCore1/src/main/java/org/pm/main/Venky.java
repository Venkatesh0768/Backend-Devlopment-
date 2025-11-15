package org.pm.main;

import org.pm.services.ICourse;

public class Venky {
    private ICourse course;

    public Venky(ICourse course){
        super();
        System.out.println("Constructor is Called Baby");
        this.course = course;
    }
    public Venky(){
        super();
        System.out.println("Venky Bean is Created");
    }

    public void  setCourse(ICourse course){
        this.course =course;
    }

    public Boolean buyTheCourse(Double amount){
        return course.getTheCourse(amount);
    }
}
