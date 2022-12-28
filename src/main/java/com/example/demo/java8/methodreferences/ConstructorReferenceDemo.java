package com.example.demo.java8.methodreferences;

import java.util.function.BiFunction;

/**
 * This example describes the User class with the fields name, surname, and a constructor to initialize them.
 * The UserFactory interface has the create() method, whose signature matches the constructor of the User class.
 * Thus, this method can be used to implement an instance of the User class.
 * Therefore, when you create an instance of the UserFactory type in the main() method of the ReferenceConstructorDemo class,
 * you use a reference to the constructor of the User class. This reference then calls the create() method.
 */
public class ConstructorReferenceDemo {
    public static void main(String[] args) {
        UserFactory userFactory = User::new;
        User user = userFactory.create("John", "Snow");
        System.out.println(user);
    }
}

class User {
    String name;
    String surname;

    User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}

interface UserFactory {
    User create(String name, String surname);
}
