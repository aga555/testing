import org.junit.jupiter.api.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

class BowlingGameTest {
    BowlingGame theGame = new BowlingGame();

    @Test
    void shouldScoreWhenRolledOne() {
        assertThat(theGame.getScore()).isEqualTo(1);
    }
}