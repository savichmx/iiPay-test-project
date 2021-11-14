package com.maksim.savich.sorter;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class MonthNameSymbolDateSorterTest {

    private final DateSorter dateSorter = new MonthNameSymbolDateSorter();
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    @Test
    void shouldSortDatesFromExampleAsExpected() {
        Set<LocalDate> unorderedDates = new LinkedHashSet<>(asList(
                createDate("01/07/2019"),
                createDate("02/01/2019"),
                createDate("01/01/2019"),
                createDate("03/05/2019")
        ));

        SortedSet<LocalDate> orderedDates = dateSorter.sortDates(unorderedDates);

        assertThat(orderedDates).containsExactly(
                createDate("01/01/2019"),
                createDate("02/01/2019"),
                createDate("01/07/2019"),
                createDate("03/05/2019")
        );
    }

    private LocalDate createDate(String date) {
        return LocalDate.parse(date, dateFormatter);
    }

}