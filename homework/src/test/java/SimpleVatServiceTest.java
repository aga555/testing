import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.StrictAssertions.assertThatThrownBy;

class SimpleVatServiceTest {

    @Test
    void getGrossPriceForDefaultVat() throws Exception {
        //given
        SimpleProduct simpleProduct = new SimpleProduct("1", 10.00);
        SimpleVatService simpleVatService = new SimpleVatService(0.23);
        //when
        double result = simpleVatService.getGrossPriceForDefaultVat(simpleProduct);
        //then
        Assertions.assertEquals(12.30, result);
    }

    @Test
    void getGrossPrice() throws Exception {
        //given
        double vat = 0.23;
        SimpleVatService simpleVatService = new SimpleVatService(vat);
        //when
        double result = simpleVatService.getGrossPrice(100, vat);
        //then
        Assertions.assertEquals(123.00, result);

    }

    @Test
    void shouldThrowExceptionWhenVatIsTooHigh() throws Exception {
        double vatValue = 1.23;
        SimpleProduct simpleProduct = new SimpleProduct("1", 100.00);
        SimpleVatService simpleVatService = new SimpleVatService(vatValue);
        assertThatThrownBy(() -> {
            simpleVatService.getGrossPrice(simpleProduct.getNetPrice(), vatValue);
        }).isInstanceOf(Exception.class)
                .hasMessageContaining("Vat must be lower!");

    }

}
