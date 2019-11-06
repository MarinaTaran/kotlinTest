package javarealisation;

public class OrderLines {
    int productId;
    String name;
    int quantity;
    int unityPrice;

    public OrderLines(int productId, String name, int quantity, int unityPrice) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.unityPrice = unityPrice;
    }

    @Override
    public String toString() {
        return "OrderLines{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", unityPrice=" + unityPrice +
                '}';
    }
}
