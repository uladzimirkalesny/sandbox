package com.example.demo.java8.methodreferences;

import java.util.function.IntPredicate;

/**
 * This example describes the ExpressionHelper class with two static methods.
 * The first one, isEven(), checks to see if the received integer value is even.
 * The second one, isPositive(), checks to see if the value is positive.
 * The sum() method of the MethodReferenceDemo class gets an array of integers and a criterion for selecting array elements
 * as an IntPredicate instance.
 * Therefore, when calling the sum() method, you can implement the IntPredicate instance via a method reference.
 * The first call returns the sum of the even elements of an array, and the second returns the sum of the positive elements.
 */
public class MethodReferenceDemo2 {
    private static int sum(int[] numbers, IntPredicate func) {
        int result = 0;
        for (int i : numbers) {
            if (func.test(i))
                result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        System.out.println(sum(nums, ExpressionHelper::isEven));
        IntPredicate expr = ExpressionHelper::isPositive;
        System.out.println(sum(nums, expr));
    }
}

class ExpressionHelper {
    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    static boolean isPositive(int n) {
        return n > 0;
    }
}
