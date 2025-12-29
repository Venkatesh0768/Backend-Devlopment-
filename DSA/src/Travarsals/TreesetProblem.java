package Travarsals;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TreesetProblem {
    public static void main(String[] args) {
        int[] arr = {1,5,3,6,7,8,9,3,5,6};
        Arrays.sort(arr);
        LinkedHashSet<Integer> treeSet = new LinkedHashSet<>();
        for(int ele : arr){
            treeSet.add(ele);
        }

        treeSet.forEach(System.out::print);
    }
}
