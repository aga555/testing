import java.util.logging.Logger;

public class SimpleVatService implements VatProvider {
    VatProvider vatProvider;
    private Logger logger = Logger.getLogger(String.valueOf(VatProvider.class));

    public SimpleVatService(VatProvider vatProvider) {
        this.vatProvider = vatProvider;
    }

    public double getGrossPriceForDefaultVat(SimpleProduct product) throws Exception {
        logger.info("DEFAULT VAT VAlUE CALCULATED");
        logger.info("GROSS PRICE CALCULATED");
        return getGrossPrice(product.getNetPrice(), vatProvider.getDefaultVat());
    }

    public double getGrossPrice(double netPrice, double vatValue) throws Exception {
        if (vatValue > 1) {
            logger.warning("WRONG VAT VALUE");
            throw new Exception("Vat must be lower!");
        }
        logger.info("GROSS PRICE CALCULATED");
        return netPrice * (1 + vatValue);
    }

    @Override
    public double getDefaultVat() {
        return 0.23;
    }

    @Override
    public double getVatForType(String type) {
        if (type == "books") {
            logger.warning("VAT VALUE FOR BOOKS-20%");
            return 0.20;
        }
        if (type == "paper") {
            logger.warning("VAT VALUE FOR PAPER-7%");
            return 0.07;
        } else {
            return getDefaultVat();
        }
    }
}