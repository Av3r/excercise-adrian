package object_programming_2.lab5.s_customers;

public class CustomerPurchase {

    private String clientId;
    private String name;
    private String productName;
    private String price;
    private String quantity;

    public CustomerPurchase(String clientId,
                            String name,
                            String productName,
                            String price,
                            String quantity) {
        this.clientId = clientId;
        this.name = name;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CustomerPurchase{" +
                "clientId='" + clientId + '\'' +
                ", name='" + name + '\'' +
                ", productName='" + productName + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
