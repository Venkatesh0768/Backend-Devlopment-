package org.pm;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurentModification {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(39);
        list.add(29);
        list.add(49);
        list.add(19);

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//            list.add(22);
//        }

//        Infintiy Loops

//         Iterator itr  = list.iterator();
//        while (itr.hasNext()){
//            System.out.println(itr.next());
//            list.add(22);
//        }
//        Execution failed for task ':org.pm.ConcurentModification.main()'.



    }
}
