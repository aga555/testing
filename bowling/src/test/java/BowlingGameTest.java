import org.junit.jupiter.api.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingGameTest {
    BowlingGame theGame = new BowlingGame();

    @Test
    void shouldScoreWhenRolledOneWithJunit() {
        assertEquals(1, theGame.getScore());

    }

    @Test
    void shouldScoreWhenRolledOneWithAssertJ() {
        assertThat(theGame.getScore()).isEqualTo(1);

    }
}