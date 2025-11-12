package Multithreading;

public class ATM extends Thread{
    private HSBC hsbc;
    public ATM(HSBC hsbc){
        this.hsbc =hsbc;
    }

    @Override
    public void run(){
        System.out.println("Withdrawing.....");
        hsbc.withdrawal(2000);
    }

}
