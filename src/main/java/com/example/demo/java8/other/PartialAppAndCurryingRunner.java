package com.example.demo.java8.other;

import org.springframework.util.Assert;

import java.util.function.BiFunction;
import java.util.function.Function;

public class PartialAppAndCurryingRunner {

    @FunctionalInterface
    protected interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }

    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> addTriFunction =
                (x, y, z) -> x + y + z;

        Function<Integer, BiFunction<Integer, Integer, Integer>> addPartial =
                x -> (y, z) -> addTriFunction.apply(x, y, z);

        BiFunction<Integer, Integer, Integer> add5 = addPartial.apply(5);

        Integer result = add5.apply(10, 15);
        Assert.isTrue(30 == result, "Result equals 30");

        BiFunction<Integer, Integer, Function<Integer, Integer>> addPartialBiFunction =
                (x, y) -> z -> addTriFunction.apply(x, y, z);

        Function<Integer, Integer> add5And10 = addPartialBiFunction.apply(5, 10);
        Assert.isTrue(30 == add5And10.apply(15), "Result equals 30");
    }
}
