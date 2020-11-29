import java.math.BigDecimal;
import java.math.MathContext;

public class VatService {
    BigDecimal vatValue;

    public VatService() {
        this.vatValue = new BigDecimal("0.23");
    }

    public BigDecimal getGrossPriceForDeafultVat(Product product) throws Exception {
        return getGrossPrice(product.getNetPrice(), vatValue);
    }

    public BigDecimal getGrossPrice(BigDecimal netPrice, BigDecimal vatValue) throws Exception {
        MathContext m = new MathContext(4);
        if (vatValue.compareTo(BigDecimal.ONE) == 1) {
            throw new Exception("Vat must be lower!");
        }
        return netPrice.multiply(vatValue.add(BigDecimal.ONE)).round(m);
    }
}
