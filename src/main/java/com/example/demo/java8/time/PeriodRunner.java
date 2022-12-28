package com.example.demo.java8.time;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Represents an amount of time in days, months and years.
 */
public class PeriodRunner {
    public static void main(String[] args) {
        Period period = Period.of(1, 1, 1);
        System.out.println("period = " + period); // period = P1Y1M1D

        Period period1 = Period.ofDays(100);
        System.out.println("period1 = " + period1); // period1 = P100D

        LocalDate localDate = LocalDate.of(2022, 1,  1);
        LocalDate localDate1 = LocalDate.now();
        Period period2 = Period.between(localDate, localDate1);
        System.out.println("period2 = " + period2); // period2 = P11M27D

        System.out.println("period2.getDays() : " + period2.getDays()); // period2.getDays() : 27

        long nrOfDaysBetweenTheDates = ChronoUnit.DAYS.between(localDate, localDate1);
        System.out.println("nrOfDaysBetweenTheDates = " + nrOfDaysBetweenTheDates); // nrOfDaysBetweenTheDates = 361
    }
}
