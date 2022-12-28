package com.example.demo.java8.methodreferences;

import java.util.function.Function;

/**
 * Method references are compact, easy-to-read lambda expressions for methods that already have a name;
 * they refer to an existing method without executing it.
 * Notice the features of using method references:
 * <ul>
 *     <li>Method references work when the parameters of the called method and the parameters in the lambda expression match.</li>
 *     <li>Method references are always converted into instances of functional interfaces.</li>
 *     <li>If several overloaded methods have the same name, the compiler finds the required one based on the context.</li>
 * </ul>
 */
public class MethodReferencesDemo1 {
    public static void main(String[] args) {
        Function<String, Integer> toInteger = MethodReferencesDemo1::parse;
        Integer integer = toInteger.apply("5");
        System.out.println("integer = " + integer);
    }

    /**
     * You can implement the apply() method of this instance through a reference to the static parse() method of the FunctionDemo class.
     * This implementation is possible because both the apply() and the parse() methods have the same parameters and return value syntax.
     */
    private static Integer parse(String s) {
        return Integer.parseInt(s);
    }
}