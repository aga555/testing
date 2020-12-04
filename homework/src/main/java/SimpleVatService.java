public class SimpleVatService {
    VatProvider vatProvider;

    public SimpleVatService(VatProvider vatProvider) {
        this.vatProvider = vatProvider;
    }

    public double getGrossPriceForDefaultVat(SimpleProduct product) throws Exception {

        return getGrossPrice(product.getNetPrice(), vatProvider.getDefaultVat());
    }


    public double getGrossPrice(double netPrice, double vatValue) throws Exception {

        if (vatValue > 1) {
            throw new Exception("Vat must be lower!");
        }

        return netPrice * (1 + vatValue);
    }
}
