package com.example.demo.java8.functionalinterfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaceRunner {
    public static void main(String[] args) {
        Supplier<List<String>> supList = () -> new ArrayList<>();
        System.out.println(supList.get());

        Consumer<String> printer = s -> System.out.println(s);
        printer.accept("Functional Interfaces in Java");

        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> con = (i, s) -> map.put(i, s); // accept(i, s)
        con.accept(1, "item one");
        con.accept(2, "item two");
        System.out.println(map);

        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(5));    // true
        System.out.println(isPositive.test(-7));    // false

        BiPredicate<String, String> pred = (s1, s2) -> s1.equals(s2);
        System.out.println(pred.test("Functional Interfaces", "Functional Interfaces in Java 8"));

        Function<String, String> func = s -> s.toUpperCase(); // apply(s) -> return s.toUpperCase()
        String afterApplyMethodString = func.apply("Functional Interfaces");
        System.out.println(afterApplyMethodString);

        BiFunction<String, String, String> biFunction = (s1, s2) -> s1.concat(s2);
        System.out.println(biFunction.apply("Functional Interfaces", " in Java 8"));

        UnaryOperator<Integer> square = x -> x * x; // apply(5) -> return 5 * 5
        System.out.println(square.apply(5));

        BinaryOperator<Integer> multiply = (x, y) -> x * y; // apply(x, y) -> return x * y
        Integer res1 = multiply.apply(3, 5);
        System.out.println(res1);
        Integer res2 = multiply.apply(10, -2);
        System.out.println(res2);

        int summator = 5;
        IntUnaryOperator sum = i -> i += summator;
        System.out.println(sum.applyAsInt(2));

        int x[] = {1};
        Consumer<Integer> consumer = n -> n += x[0]+=n;

        Suit suit = new Suit() {
            String[] suits = {"Diamonds", "Hearts", "Clubs", "Spades"};
            public String convertToSuit(int n) {
                return (n >= 1 && n < suits.length + 1)
                        ? suits[n - 1]
                        : null;
            };
        };
        System.out.println(suit.convertToSuit(3));
    }

}

interface Suit {
    String convertToSuit(int x);
}
