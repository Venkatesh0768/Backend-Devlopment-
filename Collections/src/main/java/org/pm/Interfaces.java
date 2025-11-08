package org.pm;

interface Cal1{
    void add(int a , int b);
    void sub(int a , int b);
    default void display(){
        System.out.println("Cal 1");
    }

}
interface Cal2{
    void add(int a , int b);
    void sub(int a , int b);

};

class Calculator{
    void display(){
        System.out.println();
    }
}

class Mycal extends Calculator implements  Cal1 , Cal2{

    @Override
    public void add(int a, int b) {
        System.out.println(a+b);
    }

    @Override
    public void sub(int a, int b) {
        System.out.println(a-b);

    }

    @Override
    public void display() {
        Cal1.super.display();
    }
}


public class Interfaces {

    public static void main(String[] args) {
         Mycal cal =new Mycal();
         cal.add(2 ,4);
         cal.display();
    }
}
