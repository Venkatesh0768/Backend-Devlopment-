package Multithreading;

public class GooglePay extends Thread {

    private HSBC hsbc;
    public GooglePay(HSBC hsbc){
        this.hsbc =hsbc;
    }
    @Override
    public void run(){
        System.out.println("Depositing.....");
        hsbc.deposit(200000);
    }
}
