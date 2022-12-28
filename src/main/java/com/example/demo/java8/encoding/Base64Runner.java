package com.example.demo.java8.encoding;

import java.util.Base64;

/**
 * Base64 is a way to encode Binary code to ASCII while preserving special characters when transferring text.
 */
public class Base64Runner {
    public static void main(String[] args) {
        String encoded = Base64.getEncoder().encodeToString("Bye".getBytes());
        System.out.println(encoded);

        String decoded = new String(Base64.getDecoder().decode(encoded));
        System.out.println(decoded);
    }
}
