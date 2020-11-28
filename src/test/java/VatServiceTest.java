import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class VatServiceTest {
    @Test
    void shouldCalculateGrossPriceForDeafultVat() {
        //given
        VatService vatService= new VatService();
        //when
        vatService.getGrossPriceForDeafultVat(new Product(UUID.randomUUID(), new BigDecimal("20.00")));
        //then
    }
}