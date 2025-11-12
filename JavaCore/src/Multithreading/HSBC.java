package Multithreading;

public class HSBC {
    private int accountBalance;

    public HSBC(int amount) {
        accountBalance = amount;
    }

    synchronized public void withdrawal(int amount) {
        accountBalance -= amount;
    }

    synchronized public void deposit(int amount) {
        accountBalance += amount;
    }

    synchronized public void balance() {
        System.out.println("Your account balance is " + accountBalance);
    }
}
