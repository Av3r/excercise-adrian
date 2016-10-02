package object_programming.lab1.banking;

public class BankCustomer {

    private Person person;
    private Account account;

    public BankCustomer(Person person) {
        this.person = person;
        this.account = new Account();
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return String.format("Klient: %s stan konta %.1f",
                person.getName(),account.getBalance());
    }
}
