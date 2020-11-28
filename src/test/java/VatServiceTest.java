import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class VatServiceTest {
    @Test
    void shouldCalculateGrossPriceForDefaultVat() {
        //given
        VatService vatService= new VatService();
        //when
        Product product = new Product(UUID.randomUUID(), new BigDecimal("20.00"));
        BigDecimal result = vatService.getGrossPriceForDeafultVat(product);
        //then
        assertEquals(new BigDecimal("24.60"), result);
    }
}