package object_programming.lab3.florist_simple;

public class ShoppingCart {
    private Customer customer;

    public ShoppingCart(Customer customer) {
        this.customer = customer;
    }

    public String toString() {
        return "Wózek właściciel " + customer.getName() +
                customer.toString();
    }

}
