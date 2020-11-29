import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VatServiceTest {
    VatService vatService;

    @Test
    @DisplayName("should calculate gross price for default VAT")
    void shouldCalculateGrossPriceForDefaultVat() throws Exception {
        //given
        Product product = generateProductWithPrice("20.00");
        //when
        BigDecimal result = vatService.getGrossPriceForDeafultVat(product);
        //then
        assertThat(result).isEqualTo(new BigDecimal("24.60"));

    }

    @Test
    void shouldCalculateGrossPriceForOtherVatValue() throws Exception {
        //given
        Product product = generateProductWithPrice("10.00");
        //when
        BigDecimal result = vatService.getGrossPrice(product.getNetPrice(), new BigDecimal("0.08"));
        //then
        assertThat(result).isEqualTo(new BigDecimal("10.80"));
    }

    @Test
    void shouldThrowExceptionWhenVatIsTooHigh() {
        //given
        Product product = generateProductWithPrice("10.00");
        //then
        assertThrows(Exception.class, () -> {
            vatService.getGrossPrice(product.getNetPrice(), BigDecimal.TEN);
        });
    }

    private Product generateProductWithPrice(String vat) {
        return new Product(UUID.randomUUID(), new BigDecimal(vat));
    }

    @BeforeEach
    void prepareVatService() {
        vatService = new VatService();
    }
}