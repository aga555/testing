import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {
    StringCalculator calculator;

    @Test
    void shouldReturnZeroWhenNoNumberGiven() {
        createCalculator();
        assertEquals(0, calculator.add(""));
    }

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

    @Test
    void shouldReturnSumWhenThreeNumberGiven() {
        createCalculator();
        assertEquals(8, calculator.add("5,2,1"));
    }

    private void createCalculator() {
        calculator = new StringCalculator();
    }
}