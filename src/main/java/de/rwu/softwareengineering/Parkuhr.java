package de.rwu.softwareengineering;

import java.util.ArrayList;
import java.util.List;

public class Parkuhr {

    private final List<Integer> changeCandidates = List.of(50, 20, 10, 5, 2, 1);

    public List<Integer> calculateChange(int bezahlt, int kosten) {
        if(bezahlt < kosten) {
            throw new IllegalStateException();
        }

        var diff = bezahlt - kosten;
        var i = 0;
        final var change = new ArrayList<Integer>();
        while(diff != 0) {
            final var candidate = changeCandidates.get(i);
            if(candidate <= diff) {
                change.add(candidate);
                diff -= candidate;
            } else {
                i++;
            }
        }

        return change;
    }

}
