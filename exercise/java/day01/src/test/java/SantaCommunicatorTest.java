import communication.*;
import doubles.TestLogger;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SantaCommunicatorTest {
    private final TestLogger logger = new TestLogger();
    private final SantaCommunicator communicator = new SantaCommunicator(logger);

    @Test
    void composeMessage() {
        Reindeer dasher = new Reindeer(
                new ReindeerName("Dasher"),
                new CurrentLocation("North Pole"),
                new NumbersOfDaysForComingBack(5),
                new NumberOfDaysToRest(2)
        );

        assertThat(communicator.composeMessage(dasher, new NumberOfDaysBeforeChristmas(24)))
                .isEqualTo("Dear Dasher, please return from North Pole in 17 day(s) to be ready and rest before Christmas.");
    }

    @Test
    void shouldDetectOverdueReindeer() {
        Reindeer dasher = new Reindeer(
                new ReindeerName("Dasher"),
                new CurrentLocation("North Pole"),
                new NumbersOfDaysForComingBack(24),
                new NumberOfDaysToRest(2)
        );

        assertThat(communicator.isOverdue(dasher, new NumberOfDaysBeforeChristmas(24))).isTrue();
        assertThat(logger.getLog())
                .isEqualTo("Overdue for Dasher located North Pole.");
    }

    @Test
    void shouldReturnFalseWhenNoOverdue() {
        Reindeer dasher = new Reindeer(
                new ReindeerName("Dasher"),
                new CurrentLocation("North Pole"),
                new NumbersOfDaysForComingBack(5),
                new NumberOfDaysToRest(2)
        );

        assertThat(communicator.isOverdue(dasher, new NumberOfDaysBeforeChristmas(24))).isFalse();
    }
}