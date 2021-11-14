package com.maksim.savich.sorter;

import com.maksim.savich.comparator.MonthNameSymbolComparator;

import java.time.LocalDate;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MonthNameSymbolDateSorter implements DateSorter {

    private static final char ORDER_SYMBOL = 'r';

    @Override
    public SortedSet<LocalDate> sortDates(Set<LocalDate> unsortedDates) {
        SortedSet<LocalDate> result = new TreeSet<>(new MonthNameSymbolComparator(ORDER_SYMBOL));
        result.addAll(unsortedDates);
        return result;
    }
}
