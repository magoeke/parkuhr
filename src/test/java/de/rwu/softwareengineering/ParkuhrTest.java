package de.rwu.softwareengineering;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ParkuhrTest {

    private final Parkuhr parkuhr = new Parkuhr();

    @Test
    void should_return_no_change_when_paid_equals_costs() {
        final var change = parkuhr.calculateChange(5, 5);
        assertThat(change).isEmpty();
    }

    @Test
    void should_throw_an_exception_when_paid_is_less_than_costs() {
        assertThatThrownBy(() -> parkuhr.calculateChange(2, 5))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void should_return_5_when_paid_10_and_costs_5() {
        final var change = parkuhr.calculateChange(10, 5);
        assertThat(change).contains(5);
        assertThat(change).hasSize(1);
    }

    @Test
    void should_return_2_and_1_when_paid_8_and_costs_5() {
        final var change = parkuhr.calculateChange(8, 5);
        assertThat(change).contains(2,1);
        assertThat(change).hasSize(2);
    }

}
