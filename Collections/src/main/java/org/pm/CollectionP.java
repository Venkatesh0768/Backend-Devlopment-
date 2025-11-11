package org.pm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class Students {
    int marks;
    String name;

    public Students(int marks, String name) {
        this.marks = marks;
        this.name = name;

    }

    @Override
    public String toString() {
        return "Students{" +
                "marks=" + marks +
                ", name='" + name + '\'' +
                '}';
    }
}

//Implementation 1
//class Alpha implements Comparator<Students>{
//
//    @Override
//    public int compare(Students o1, Students o2) {
//        if (o1.marks >  o2.marks){
//            return  1;
//        }else {
//            return  -1;
//        }
//    }
//}

public class CollectionP {
    public static void main(String[] args) {
        ArrayList<Students> list = new ArrayList<>();
        list.add(new Students(22, "venky"));
        list.add(new Students(21, "Akash"));
        list.add(new Students(23, "Sushi"));
        list.add(new Students(24, "Rahul"));


//        Comparator<Students> c = new Comparator<Students>() {
//
//            @Override
//            public int compare(Students o1, Students o2) {
//                if (o1.marks > o2.marks) {
//                    return 1;
//                } else {
//                    return -1;
//                }
//            }
//        };

//        anomoys class


        Comparator<Students> c = (o1, o2) -> {

            if (o1.marks > o2.marks) {
                return 1;
            } else {
                return -1;
            }

        };

        Collections.sort(list, c);
        System.out.println(list);


    }
}
