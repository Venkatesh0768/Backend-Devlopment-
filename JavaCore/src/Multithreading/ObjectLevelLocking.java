package Multithreading;

public class ObjectLevelLocking {
    public static void main(String[] args) {
        HSBC hsbc = new HSBC(40000);

        ATM atm = new ATM(hsbc);
        atm.setName("Atm Thread");

        GooglePay googlePay = new GooglePay(hsbc);
        googlePay.setName("GooglePay Thread");

        PhonePay phonePay = new PhonePay(hsbc);
        phonePay.setName("Phonepay Thread");

        atm.start();
        googlePay.start();
        phonePay.start();


    }
}
