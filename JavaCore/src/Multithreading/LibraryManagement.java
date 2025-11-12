package Multithreading;

public class  LibraryManagement extends Thread{
    String res1 = "Java";
    String res2 = "DSA";
    String res3 = "SpringBoot";

    @Override
    public void run(){
        String name  = Thread.currentThread().getName();
        System.out.println(name+ " " + Thread.currentThread().getState());
        if (name.equals("Student1")){
            try {
                synchronized (res3){
                    System.out.println(name  + " " + res1);
                    Thread.sleep(2000);
                    synchronized (res2){
                        System.out.println(name  + " " + res2);
                        Thread.sleep(2000);

                        synchronized (res1){
                            System.out.println(name  + " " + res3);
                            Thread.sleep(2000);
                        }
                    }

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            try {
                synchronized (res1){
                    System.out.println(name  + " " + res1);
                    Thread.sleep(2000);
                    synchronized (res2){
                        System.out.println(name  + " " + res2);
                        Thread.sleep(2000);

                        synchronized (res3){
                            System.out.println(name  + " " + res3);
                            Thread.sleep(2000);
                        }
                    }

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
