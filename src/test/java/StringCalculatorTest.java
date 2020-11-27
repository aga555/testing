import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {
@Test
    void shouldReturnNumberWhenNumberGiven(){
    StringCalculator calculator= new StringCalculator();
    assertEquals(2,calculator.add("2"));
}

    @Test
    void shouldReturnSumWhenTwoNumberGiven() {
    StringCalculator calculator= new StringCalculator();
    assertEquals(4,calculator.add("2,2"));
    }
}