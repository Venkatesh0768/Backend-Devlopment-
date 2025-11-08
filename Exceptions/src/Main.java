public class Main {
    public static void main(String[] args) {
        try{
            int a = 34/0;
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }

    }
}