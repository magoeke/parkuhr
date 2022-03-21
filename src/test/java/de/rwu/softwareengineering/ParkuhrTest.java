package de.rwu.softwareengineering;

import static org.assertj.core.api.Assertions.assertThat;


class ParkuhrTest {

    void test() {
        final var parkuhr = new Parkuhr();
        final var change = parkuhr.calculateChange(0, 0);
        assertThat(change).isEmpty();
    }

}
