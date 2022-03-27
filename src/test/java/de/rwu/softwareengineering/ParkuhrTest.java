package de.rwu.softwareengineering;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ParkuhrTest {

    private Parkuhr parkuhr = new Parkuhr();

    @Test
    void should_return_no_change_when_paid_amount_equals_costs() {
        final var change = parkuhr.calculateChange(0, 0);

        assertThat(change).isEmpty();
    }

    @Test
    void should_throw_exception_when_too_little_was_paid() {
        assertThatThrownBy(() -> parkuhr.calculateChange(0, 1))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void should_return_5_when_10_was_paid_and_it_costs_5() {
        final var change = parkuhr.calculateChange(10, 5);

        assertThat(change).contains(5);
    }

    @Test
    void should_return_2_and_1_when_8_was_paid_and_it_costs_5() {
        final var change = parkuhr.calculateChange(8, 5);

        assertThat(change).contains(2, 1);
    }

}
