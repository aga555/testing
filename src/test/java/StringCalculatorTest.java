import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {
    StringCalculator calculator;

    @Test
    void shouldReturnNumberWhenNumberGiven() {
        createCalculator();
        assertEquals(2, calculator.add("2"));
    }

    @Test
    void shouldReturnSumWhenTwoNumberGiven() {
        createCalculator();
        assertEquals(4, calculator.add("2,2"));
    }

    private void createCalculator() {
        calculator = new StringCalculator();
    }
}