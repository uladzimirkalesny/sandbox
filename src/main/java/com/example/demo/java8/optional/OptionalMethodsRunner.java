package com.example.demo.java8.optional;

import java.util.Optional;

/**
 * List of Optional methods:
 * <ul>
 *     <li>isPresent - check whether a non-null value is in the Optional</li>
 *     <li>get - retrieve value from Optional and should be using with isPresent method to avoid NoSuchElementException or NullPointerException</li>
 *     <li>orElse - check whether a non-null value is in the Optional. If not, a default value is specified</li>
 *     <li>orElseGet - similar to orElse but instead of specifying a value, a Supplier is specified. The Supplier will be used for getting the value in case the Optional is empty</li>
 *     <li>orElseThrow - whether you want to throw a specific exception when the value is not present. Specify what needs to be executed if no elements is present in the Optional</li>
 *     <li>filter - if the element doesn't match the Predicate, it returns an empty Optional</li>
 *     <li>map - specifies an operation to be applied to the non-null value; if there is no value, it will return an empty Optional.</li>
 * </ul>
 */
public class OptionalMethodsRunner {
    public static void main(String[] args) {
        Optional<User> optionalUser = Optional.of(new User("John"));
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println(user);
        }

         optionalUser = Optional.empty();
        // System.out.println(optionalUser.get()); // NoSuchElementException - No value present

        User adam = optionalUser.orElse(new User("Adam"));
        System.out.println("user = " + adam);

        //optionalUser.orElseThrow(() -> new NullPointerException("no value")); // NPE -  no value

        User tom = optionalUser.orElseGet(() -> new User("Tom"));
        System.out.println("user = " + tom); // user = User(name=Tom)

        User luke = optionalUser.filter(u -> u.getName().startsWith("L")).orElse(new User("Luke"));
        System.out.println("user = " + luke);

        Optional<Integer> optionalInteger = Optional.of(12);
        String result = optionalInteger.map(intVal -> intVal.toString()).get();
        System.out.println("result = " + result);
    }
}
