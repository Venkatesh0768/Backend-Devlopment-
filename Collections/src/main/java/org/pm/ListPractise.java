package org.pm;

import java.util.*;

public class ListPractise {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(232);
        list.add(223);

        list.remove(1);

        System.out.println(list);


//        HashSet<Integer> set = new HashSet<>();
//        set.add(21);
//        set.add(32);
//        set.add(43);
//        set.add(24);
//        System.out.println(set);

//        LinkedHashSet<Integer> set = new LinkedHashSet<>();
//        set.add(21);
//        set.add(32);
//        set.add(43);
//        set.add(24);
//        System.out.println(set);
//        [21, 32, 43, 24]

        TreeSet<Integer> set = new TreeSet<>();
        set.add(21);
        set.add(32);
        set.add(43);
        set.add(24);
        System.out.println(set);
//        [21, 24, 32, 43]

//        for(int ele : set){
//            System.out.println(ele);
//        }
        HashMap<String , Integer> check  = new HashMap<>();
        check.put("venktesh" , 1);
        check.put("Rahul" , 2);
        check.put("Venky" , 3);


        for(Map.Entry<String, Integer> ans : check.entrySet()){
            System.out.println(ans.getKey() +  " " + ans.getValue());
        }

        for (String ans : check.keySet()){
            System.out.println(ans + " " + check.get(ans));
        }

        check.forEach((key, value) -> System.out.println(key + " " + value));

    }
}
