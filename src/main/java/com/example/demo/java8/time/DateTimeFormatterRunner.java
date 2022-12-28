package com.example.demo.java8.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTimeFormatterRunner {
    public static void main(String[] args) {
        LocalDateTime ld1 = LocalDateTime.now();
        String format = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(ld1);
        System.out.println("format = " + format); // format = 2022-12-28T03:40:55.5557056

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
        String format1 = dateTimeFormatter.format(ld1);
        System.out.println("format1 = " + format1); // format1 = 28-December-2022

        String format2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(ld1);
        System.out.println("format2 = " + format2); // format2 = Dec 28, 2022, 3:40:55 AM
    }
}
