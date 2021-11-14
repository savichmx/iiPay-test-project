package com.maksim.savich.comparator;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Locale;

public class MonthNameSymbolComparator implements Comparator<LocalDate> {

    private final String orderSymbol;

    public MonthNameSymbolComparator(char orderSymbol) {
        this.orderSymbol = String.valueOf(orderSymbol).toUpperCase(Locale.ROOT); // putting to uppercase as all month names are in upper case
    }

    @Override
    public int compare(LocalDate date1, LocalDate date2) {
        boolean firstDateContainsOrderSymbol = date1.getMonth().name().contains(orderSymbol);
        boolean secondDateContainsOrderSymbol = date2.getMonth().name().contains(orderSymbol);

        if (firstDateContainsOrderSymbol && secondDateContainsOrderSymbol) {
            return date1.compareTo(date2);
        } else if (firstDateContainsOrderSymbol) {
            return -1;
        } else if (secondDateContainsOrderSymbol) {
            return 1;
        } else {
            return date1.compareTo(date2) * -1;
        }
    }
}
