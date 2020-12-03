import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Testoranki {
    @Test
    void shouldReturnSumWhenTwoNumberGiven() {
        //given
        int first = 2;
        int second = 2;
        //when
        int expected = first + second;
        //then
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

    @Test
    void shouldReturnWhenGivenDateIsFromPast() {
        //given
        Date d1 = new Date(2220, 11, 25, 8, 30);
        Date d2 = new Date(System.currentTimeMillis());
        //when
        boolean isFromPast = d1.compareTo(d2) < 0;
        //then
        assertTrue(isFromPast);
    }
}

