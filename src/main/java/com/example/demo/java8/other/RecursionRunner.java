package com.example.demo.java8.other;

public class RecursionRunner {
    public static void main(String[] args) {
        countDownWithEndCondition(0, 10);
    }

    private static void countDownWithEndCondition(Integer x, Integer end) {
        if (x > end) {
            System.out.println("done");
            return;
        }
        System.out.println(x);
        countDownWithEndCondition(x + 1, end);
    }

    private static void countUp(Integer x) {
        if (x > 10) {
            System.out.println("done");
            return;
        }
        System.out.println(x);
        countUp(x + 1);
    }

    private static void countDown(Integer x) {
        if (x == 0) {
            System.out.println("done");
            return;
        }
        System.out.println(x);
        countDown(x - 1);
    }
}
