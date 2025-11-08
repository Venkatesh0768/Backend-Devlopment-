import java.io.FileReader;
import java.io.IOException;

public class ThrowsException {
    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("This is Working");

      try {
          login("Venky");
      }catch (InvalidUser e){
          System.out.println(e.getMessage());
      }

    }

    static void login(String user) throws InvalidUser{
        if (!user.equals("venkatesh")){
            throw new InvalidUser("User is not valid");
        }
        System.out.println("User is valid to login");
    }

    static void readFile() throws IOException {
        FileReader f = new FileReader("data.txt");
    }
}
