package org.pm.looscoupling;

import java.util.ArrayList;
import java.util.List;

class Generics<T>{
    private T ref;

    Generics(T ref){
        this.ref = ref;
    }

    public T getRef(){
        return ref;
    }
    public void display(){
        System.out.println("Type Safety of the Generics" + ref.getClass().getName());
    }
}


public class GenericsType {
    public static void main(String[] args) {
        Generics<String> generics = new Generics<>("Venky");
        System.out.println( generics.getRef());
        generics.display();

        List<? extends Number> list = List.of(
                2,3,5,4,5
        );

        System.out.println(list.get(1));
    }
}
