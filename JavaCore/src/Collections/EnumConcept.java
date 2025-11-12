package Collections;


enum Students {
    PASS,
    FAIL,
    AVG

//    public static final Students Pass  = new Students();
}

public class EnumConcept {

    public static void main(String[] args) {
        Students s = Students.AVG;
        System.out.println(s);
    }
}

