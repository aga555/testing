import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Testoranki {
    @Test
    void shouldReturnSumWhenTwoNumberAddTwo() {
        int expected = 2 + 2;
        Assertions.assertEquals(4, expected);
    }

    @Test
    void shouldReturnTrueWhenGivenWordContainsLetterA() {
        //given
        String actual = "testoranki";
        String letter = "a";
        //when
        boolean expected = actual.contains(letter);
        //then
        assertTrue(expected);

    }

}

