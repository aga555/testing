public class SimpleProduct {
    String id;
    double netPrice;
    String type;

    public SimpleProduct(String id, double netPrice,
                         String type) {
        this.id = id;
        this.netPrice = netPrice;
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
