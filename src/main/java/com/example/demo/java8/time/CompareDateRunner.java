package com.example.demo.java8.time;

import java.time.LocalDateTime;

public class CompareDateRunner {
    public static void main(String[] args) {
        LocalDateTime ld1 = LocalDateTime.now();
        LocalDateTime ld2 = LocalDateTime.of(2022, 2, 1, 2, 3);

        System.out.println(ld1.compareTo(ld2));
        System.out.println(ld1.isAfter(ld2));
        System.out.println(ld1.isBefore(ld2));
        System.out.println(ld1.isEqual(ld2));
    }
}
