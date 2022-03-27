package de.rwu.softwareengineering;

import java.util.ArrayList;
import java.util.List;

public class Parkuhr {

    private final List<Integer> changeOptions = List.of(50, 20, 10, 5, 2, 1);

    public List<Integer> calculateChange(int bezahlt, int kosten) {
        if(bezahlt < kosten) {
            throw new IllegalStateException();
        }

        final var change = new ArrayList<Integer>();
        var diff = bezahlt - kosten;
        var i = 0;
        while(diff != 0) {
            final var changeCandidate = changeOptions.get(i);

            if(changeCandidate <= diff) {
                change.add(changeCandidate);
                diff -= changeCandidate;
            } else {
                i++;
            }
        }

        return change;
    }

}
