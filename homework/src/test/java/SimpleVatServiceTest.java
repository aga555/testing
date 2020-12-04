import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.StrictAssertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

class SimpleVatServiceTest {
    VatProvider vatProvider;
    SimpleVatService simpleVatService;

    @Test
    void getGrossPriceForDefaultVat() throws Exception {
        //given
        when(vatProvider.getDefaultVat()).thenReturn(0.23);
        SimpleProduct simpleProduct = new SimpleProduct("1", 10.00, "book");
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
        assertThatThrownBy(() -> simpleVatService.getGrossPrice(100, vatValue)).isInstanceOf(Exception.class)
                .hasMessageContaining("Vat must be lower!");
    }

    @BeforeEach
    void prepareVatService() {
        vatProvider = Mockito.mock(VatProvider.class);
        simpleVatService = new SimpleVatService(vatProvider);
    }

}
