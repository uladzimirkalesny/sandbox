package com.example.demo.java8.methodreferences;

import java.util.function.IntPredicate;

/**
 * This example demonstrates a class with one instance method, isEven().
 * This method checks to see if the received integer value is even.
 * The LambdaApp1 class has the sum() method, which receives an array of integers and a criterion for selecting array elements as an IntPredicate instance.
 * The sum() method in the main() method finds the sum of the even elements of the nums array (while a call to the test() method of the
 * IntPredicate type checks the sum).
 * Since the signature of the isEven() method of the ExpressionHelperEven class is the same as that of the test() method of the IntPredicate
 * type, you can specify a method reference as the second argument when calling the sum() method.
 */
public class ReferenceToInstanceMethodDemo {
    private static int sum(int[] numbers, IntPredicate func) {
        int result = 0;
        for (int i : numbers) {
            if (func.test(i)) {
                result += i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5};
        ExpressionHelperEven exprHelper = new ExpressionHelperEven();
        System.out.println(sum(nums, exprHelper::isEven));
    }
}

class ExpressionHelperEven {
    boolean isEven(int n) {
        return n % 2 == 0;
    }
}
