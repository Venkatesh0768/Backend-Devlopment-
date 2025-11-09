package org.pm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class LambdaCollections {

    public static void main(String[] args) {
        List<String> list  = Arrays.asList("Venkatesh", "Bhavik", "Rinkesh", "Aryan");
        List<Integer> numbers  = Arrays.asList(1,2,45,6,7,3,7,8,49,5,10);

        list.forEach(System.out::println);
        list.stream().filter(name  -> name.startsWith("V")).forEach(System.out::println);
        Predicate<Integer> isPrime  = n -> n %2 ==0;
        System.out.println(isPrime.test(40));

        HashMap<Integer , String> map = new HashMap<>();
        map.put(1, "venky");
        map.put(2, "Rahul");
        map.put(3, "Bhavik");
        map.put(4, "Lohit");
        map.put(5, "Vivek");

        numbers.stream().filter(n -> n %2 ==0).forEach(System.out::println);
        map.forEach((key, value) -> System.out.println(key + " " + value));
        String longest = list.stream().max((s1 , s2 )->  s1.length() - s2.length())
                .orElse(null);
        System.out.println(longest);

        list.stream().map(s -> new StringBuilder(s).reverse().toString())
                .forEach(System.out::println);

    }
}
