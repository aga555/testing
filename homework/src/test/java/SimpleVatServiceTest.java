import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThatThrownBy;

class SimpleVatServiceTest {
    double vatValue = 0.23;
    SimpleVatService simpleVatService;

    @Test
    void getGrossPriceForDefaultVat() throws Exception {
        //given
        SimpleProduct simpleProduct = new SimpleProduct("1", 10.00);
        //when
        double result = simpleVatService.getGrossPriceForDefaultVat(simpleProduct);
        //then
        assertThat(result).isEqualTo(12.30);
    }


    @Test
    void getGrossPrice() throws Exception {
        //when
        double result = simpleVatService.getGrossPrice(100, 0.23);
        //then
        assertThat(result).isEqualTo(123);

    }

    @Test
    void shouldThrowExceptionWhenVatIsTooHigh() throws Exception {
        double vatValue = 1.23;
        SimpleProduct simpleProduct = new SimpleProduct("1", 100.00);
        assertThatThrownBy(() -> simpleVatService.getGrossPrice(simpleProduct.getNetPrice(), vatValue)).isInstanceOf(Exception.class)
                .hasMessageContaining("Vat must be lower!");
    }

    @BeforeEach
    void prepareVatService() {
        simpleVatService = new SimpleVatService(vatValue);
    }

}
