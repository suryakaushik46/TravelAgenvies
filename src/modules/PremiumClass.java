package modules;

public class PremiumClass{
    private int discount;
    private int balance;

    public PremiumClass(int discount, int balance) {
        this.discount = discount;
        this.balance = balance;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getDiscount() {
        return discount;
    }

    public int getBalance() {
        return balance;
    }
}
