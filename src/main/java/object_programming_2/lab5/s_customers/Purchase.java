package object_programming_2.lab5.s_customers;

public class Purchase {

    private String clientId;
    private String name;
    private String productName;
    private double price;
    private double quantity;

    public Purchase(String clientId,
                    String name,
                    String productName,
                    double price,
                    double quantity) {
        this.clientId = clientId;
        this.name = name;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public double calculateTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%.1f;%.1f",
                clientId,
                name,
                productName,
                price,
                quantity);
    }

    public String toStringWithTotalPrice() {
        return toString() +
                String.format(" (koszt: %.1f)", calculateTotalPrice());
    }


}
