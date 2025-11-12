import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class PassPort{
    private String name ;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public PassPort(String name, String country) {
        this.name = name;
        this.country = country;
    }
}

public class HashMapProject {
    public static void main(String[] args) {
        PassPort p1 = new PassPort("venky" , "India");
        PassPort p2 = new PassPort("Rahul" , "UK");
        PassPort p3 = new PassPort("Akash" , "Canada");
        HashMap<Integer , PassPort> passportDetails  = new HashMap<>();
        passportDetails.put(101, p1);
        passportDetails.put(102, p2);
        passportDetails.put(103, p3);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the detail of the Passport");
        int x = sc.nextInt();
        if(passportDetails.containsKey(x)){
            PassPort answer = passportDetails.get(x);
            System.out.println(answer.getName() + " " + answer.getCountry());
        }else {
            System.out.println("Sorry yor detail in not present in the ");
        }


    }

}
