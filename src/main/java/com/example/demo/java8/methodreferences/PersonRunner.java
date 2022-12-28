package com.example.demo.java8.methodreferences;

import java.util.function.Function;
import java.util.function.Supplier;

public class PersonRunner {
    public static void main(String[] args) {
        Function<String, Person> stringToPerson = Person::new;
        Supplier<Person> personSupplier = Person::new;
    }
}

class Person {
    public Person() {}
    public Person(final String name) {}
}