package com.example.demo.java8.time;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Represents an amount of time in seconds or nanosecond.
 * Minutes and hours and the DAYS unit can be used to work with Durations.
 */
public class DurationRunner {
    public static void main(String[] args) {
        Duration duration = Duration.of(1, ChronoUnit.DAYS);
        System.out.println("duration = " + duration); // duration = PT24H

        Duration duration1 = Duration.ofHours(5);
        System.out.println("duration1 = " + duration1); // duration1 = PT5H

        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.of(15, 12);
        Duration duration2 = Duration.between(localTime, localTime1);
        System.out.println("duration2 = " + duration2); // duration2 = PT11H19M40.9311251S
    }
}
