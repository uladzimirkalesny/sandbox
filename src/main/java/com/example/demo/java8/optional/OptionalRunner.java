package com.example.demo.java8.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * Optional is a container that may or may not contain a non-null value.
 * Mostly, Optional uses as returns types (for example, querying the data layer) and avoid the constant null checks.
 * Optional is for returning only. It should not be used as a parameter or field type.
 */
public class OptionalRunner {
    public static void main(String[] args) {
        Optional<User> emptyOptional = Optional.empty();
        System.out.println("Empty optional: " + emptyOptional.isPresent());

        Optional<User> optionalUser1 = Optional.of(new User("John"));
        System.out.println("Optional user 1 : " + optionalUser1.isPresent());

        User nullableUser = null;
        // Optional<User> optionalUser2 = Optional.of(nullableUser); // no compile errors but NPE
        // System.out.println("Optional user 2 : " + optionalUser2.isPresent());

        Optional<User> optionalUser3 = Optional.ofNullable(nullableUser);
        System.out.println("Optional user 3 : " + optionalUser3.isPresent()); // Optional user 3 : false

    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    String name;
}