package com.example.demo.java8.other;

import org.springframework.util.Assert;

import java.util.function.BiFunction;
import java.util.function.Function;

public class DivideSafeRunner {
    public static void main(String[] args) {
        BiFunction<Float, Float, Float> divideFunction = (x, y) -> x / y;

        Function<BiFunction<Float, Float, Float>, BiFunction<Float, Float, Float>> checkSecondArgumentNonEqualsZero =
                (biFunction) ->
                        (x, y) -> {
                            if (y == 0F) {
                                System.out.println("Error: The second argument is zero");
                                return 0F;
                            }
                            return biFunction.apply(x, y);
                        };

        BiFunction<Float, Float, Float> safeDivide = checkSecondArgumentNonEqualsZero.apply(divideFunction);
        Float result = safeDivide.apply(10F, 10F);
        Assert.isTrue(1F == result);

        Float zeroResult = safeDivide.apply(10F, 0F);
        Assert.isTrue(0F == zeroResult);

    }
}
