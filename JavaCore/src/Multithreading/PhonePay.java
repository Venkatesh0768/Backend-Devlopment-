package Multithreading;

public class PhonePay extends Thread {

    private HSBC hsbc;
    public PhonePay(HSBC hsbc){
        this.hsbc =hsbc;
    }
    @Override
    public void run(){
        System.out.println("Depositing.....");
        hsbc.balance();
    }
}
