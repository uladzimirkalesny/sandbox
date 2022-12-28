package com.example.demo.java8.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class ConvertDateAndCalendarRunner {
    public static void main(String[] args) {
        Date date = new Date(122, 2, 2);
        System.out.println("date = " + date); // date = Wed Mar 02 00:00:00 MSK 2022
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("localDateTime = " + localDateTime); // localDateTime = 2022-03-02T00:00

        Calendar calendar = Calendar.getInstance();
        LocalDateTime localDateTime1 = calendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println("localDateTime1 = " + localDateTime1); // localDateTime1 = 2022-12-28T04:07:46.307
    }
}
