package object_programming.lab1.banking;

public class Account {

    private static double rate;

    private double balance;

    public void deposit(double value) {
        if(value <= 0) return;
        this.balance += value;
    }

    public void withdraw(double value) {
        if(value<= 0) return;
        this.balance -= value;
    }

    public void transfer(Account toAccount, double value) {
        if(value > balance) return;
        this.balance -= value;
        toAccount.deposit(value);
    }

    public void addInterest() {
        this.balance += balance * rate / 100;
    }

    public double getBalance() {
        return balance;
    }

    public static void setInterestRate(double rate) {
        if(rate < 0) return;
        Account.rate = rate;
    }
}
