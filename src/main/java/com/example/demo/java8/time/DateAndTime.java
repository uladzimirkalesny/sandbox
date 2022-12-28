package com.example.demo.java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;
import java.util.stream.Stream;

public class DateAndTime {
    public static void main(String[] args) {
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2022, 12, 22);
        LocalDate localDate3 = LocalDate.of(2022, Month.DECEMBER, 22);

        printObjects(localDate1, localDate2, localDate3);

        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(12, 25);

        printObjects(localTime1, localTime2);

        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(2022, Month.DECEMBER, 22, 12, 25);
        LocalDateTime localDateTime3 = LocalDateTime.of(localDate3, localTime2);

        printObjects(localDateTime1, localDateTime2, localDateTime3);

        MonthDay monthDay = MonthDay.of(Month.DECEMBER, 22);
        LocalDate localDate4 = monthDay.atYear(2022);

        YearMonth yearMonth = YearMonth.now();
        LocalDate localDate5 = yearMonth.atDay(22);

        printObjects(localDate4, localDate5);
    }

    @SafeVarargs
    private static <T> void printObjects(T... objects) {
        Stream.of(objects).forEach(System.out::println);
    }
}
