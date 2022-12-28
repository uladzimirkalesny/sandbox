package com.example.demo.java8.time;

import java.time.Clock;
import java.time.Duration;
import java.time.Instant;

/**
 * Abstract Class that provides access to Instant, date, and time using a time zone.
 * Usage is optional and allows alternate clocks.
 */
public class Clocks {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock); // SystemClock[Europe/Minsk]

        Instant instant = clock.instant();
        System.out.println(instant); // 2022-12-21T22:13:10.403145200Z

        Clock clockUTC = Clock.systemUTC();
        System.out.println("clockUTC = " + clockUTC); // clockUTC = SystemClock[Z]

        Instant instantUTC = clockUTC.instant();
        System.out.println("instantUTC = " + instantUTC); // instantUTC = 2022-12-21T22:13:10.407897500Z

        Clock offsetClock = Clock.offset(clock, Duration.ofHours(2));
        System.out.println("offsetClock = " + offsetClock); // offsetClock = OffsetClock[SystemClock[Europe/Minsk],PT2H]

        Instant offsetClockInstant = offsetClock.instant();
        System.out.println("offsetClockInstant = " + offsetClockInstant); // offsetClockInstant = 2022-12-22T00:13:10.407897500Z
    }
}
