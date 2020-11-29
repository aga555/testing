import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VatServiceTest {
    VatService vatService;

    @Test
    @DisplayName("should calculate gross price for default VAT")
    void shouldCalculateGrossPriceForDefaultVat() {
        //given
        Product product = generateProductWithPrice("20.00");
        //when
        BigDecimal result = vatService.getGrossPriceForDeafultVat(product);
        //then
        assertEquals(new BigDecimal("24.60"), result);
    }

    @Test
    void shouldCalculateGrossPriceForOtherVatValue() {
        //given
        Product product = generateProductWithPrice("10.00");
        //when
        BigDecimal grossPrice = vatService.getGrossPrice(product.getNetPrice(), new BigDecimal("0.08"));
        //then
        assertEquals(new BigDecimal("10.80"), grossPrice);
    }

    private Product generateProductWithPrice(String vat) {
        return new Product(UUID.randomUUID(), new BigDecimal(vat));
    }

    @BeforeEach
    void prepareVatService() {
        vatService = new VatService();
    }
}