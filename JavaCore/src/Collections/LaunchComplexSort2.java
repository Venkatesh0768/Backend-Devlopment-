package Collections;

import java.util.Comparator;
import java.util.List;

class  Cricketer implements Comparable<Cricketer>{
    int age;
    double score;
    String name;

    public Cricketer(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Cricketer o) {
        if(this.age > o.age) return 1;
        else return  -1;
    }
}

public class LaunchComplexSort2 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,1,4,6556,6,7,7);
    }
}
