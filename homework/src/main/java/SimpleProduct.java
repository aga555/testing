
public class SimpleProduct {
    String id;
    double netPrice;

    public SimpleProduct(String id, double netPrice) {
        this.id = id;
        this.netPrice = netPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }
}
