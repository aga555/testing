public class SimpleVatService {
    double vatValue;

    public SimpleVatService(double vatValue) {
        this.vatValue = 0.23;
    }

    public double getGrossPriceForDefaultVat(SimpleProduct product) throws Exception {

        return getGrossPrice(product.getNetPrice(), vatValue);
    }

    public double getGrossPrice(double netPrice, double vatValue) throws Exception {

        if (vatValue > 1) {
            throw new Exception("Vat must be lower!");
        }

        return netPrice * (1 + vatValue);
    }
}
