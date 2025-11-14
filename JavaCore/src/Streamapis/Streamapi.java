package Streamapis;

import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Streamapi {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i =20; i>=0; i--) list.add(i);
        list2.add("Venkatesh");
        list2.add("rahul");
        list2.add("Venkyr");

        list.stream().max(Integer::compareTo);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

//        System.out.println(list2.stream().max((str1, str2) -> {
//            if (str1.length() > str2.length()) return 1;
//            else return  -1;
//        }));
//
//        list.stream().filter(i -> i%2 ==0).forEach(l -> System.out.println(l));
//
//        System.out.println( list.stream().sorted());
//
//
//        list.stream().forEach((a)-> System.out.println(a));
//        System.out.println(list.stream().reduce((Integer::compareTo)));

        list.stream().sorted((a , b) -> {if(a>b) return 1; else return -1;}).forEach(c -> System.out.println(c));


        //map vs flatmap
        List<String> names = List.of("Venky", "Ramesh");
        List<List<Integer>> mlist = List.of(List.of(1,2), List.of(3,4));

        names.stream().map(String::toUpperCase).forEach(System.out::println);
        mlist.stream().flatMap(Collection::stream).forEach(System.out::println);






    }
}
