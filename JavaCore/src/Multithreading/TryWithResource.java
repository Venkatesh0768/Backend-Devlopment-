package Multithreading;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResource {
    public static void main(String[] args) throws IOException {

        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\java.txt"))){
            System.out.println("Connection Opened");
        }catch (Exception e){
            e.getMessage();
        }
    }
}
