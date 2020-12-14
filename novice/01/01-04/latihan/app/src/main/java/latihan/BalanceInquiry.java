package latihan;

public class BalanceInquiry extends MainClass {
    static double balance = 0;
    public void getBalance(double b) {
        balance = b;
    }
    public static double getBalance() {
        return balance;
    }
}
