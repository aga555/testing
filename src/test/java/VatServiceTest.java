import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class VatServiceTest {
    VatService vatService;
    VatProvider vatProvider;

    @Test
    @DisplayName("should calculate gross price for default VAT")
    void shouldCalculateGrossPriceForDefaultVat() throws IncorectVatException {
        //given
        Mockito.when(vatProvider.getDefaultVat()).thenReturn(new BigDecimal("0.23"));
        Product product = generateProduct("20.00", "clothes");
        //when
        BigDecimal result = vatService.getGrossPriceForDefaultVat(product);
        //then
        assertThat(result).isEqualTo(new BigDecimal("24.60"));

    }

    @Test
    void shouldCalculateGrossPriceForOtherVatValue() throws IncorectVatException {
        //given
        String type = "fruit";
        Product product = generateProduct("10.00",type);
        Mockito.when(vatProvider.getVatForType(type)).thenReturn(new BigDecimal(0.08));
        //when
        BigDecimal result = vatService.getGrossPrice(product.getNetPrice(), type);
        //then
        assertThat(result).isEqualTo(new BigDecimal("10.80"));
    }

/*    @Test
    void shouldThrowExceptionWhenVatIsTooHigh() {
        //given
        Product product = generateProduct("10.00", "car");
        //then
        assertThrows(Exception.class, () -> {
            vatService.getGrossPrice(product.getNetPrice(), BigDecimal.TEN, ),;
        });
    }*/



    @BeforeEach
    void prepareVatService() {
        vatProvider = Mockito.mock(VatProvider.class);
        vatService = new VatService(vatProvider);
    }

    private Product generateProduct(String vat, String type) {
        return new Product(UUID.randomUUID(), new BigDecimal(vat), type);
    }
}