package com.example.demo.java8.time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Instant: object representing a point in time.
 * ZonedDateTime: object representing a date and time zone.
 * Zones are going to help capture an actual moment.
 * ZoneId: used to convert between an Instant and a LocalDateTime, either a fixed offset or geographical region.
 */
public class ZonedDateTimeAndZoneId {
    public static void main(String[] args) {
        ZoneId.getAvailableZoneIds().forEach(System.out::println);

        String australiaHobartZoneId = "Australia/Hobart";
        ZoneId zoneId = ZoneId.of(australiaHobartZoneId);

        // zoneId = Australia/Hobart and display name = Eastern Australia Time
        System.out.println("zoneId = " + zoneId + " and display name = " + zoneId.getDisplayName(TextStyle.FULL, Locale.US));

        ZoneId newZoneId = ZoneId.of("US/Pacific");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(localDateTime, newZoneId);

        // zonedDateTime = 2022-12-22T01:08:58.882281700-08:00[US/Pacific]
        System.out.println("zonedDateTime = " + zonedDateTime1);

        ZonedDateTime zonedDateTime2 = localDateTime.atZone(newZoneId);
        ZonedDateTime zonedDateTime3 = ZonedDateTime.now();

        // Europe/Minsk
        System.out.println(zonedDateTime3.getZone());
    }
}
