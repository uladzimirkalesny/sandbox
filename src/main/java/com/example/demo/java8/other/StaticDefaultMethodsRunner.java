package com.example.demo.java8.other;

public class StaticDefaultMethodsRunner {
    public static void main(String[] args) {
        FooBar.foo();
        FooBar fooBar = new Try();
        fooBar.bar();
    }
}

interface FooBar {
    /**
     * An interface can contain static methods since Java 8
     * These methods are implemented with a method body
     * Can only be called on the interface (InterfaceName.staticMethodName())
     * Can not be overridden or hidden in the class and belong to the interface.
     */
    static void foo() {
        System.out.println("foo");
    }

    /**
     * Allows for a non-static method on an interface to have a body
     * Adding a default implementation can avoid breaking the code when changing the interface and enhance backward compatibility
     * Default method can be overriden in class that implements the interface
     */
    default void bar() {
        System.out.println("bar");
    }
}

class Try implements FooBar {
    @Override
    public void bar() {
        System.out.println("foo-bar");
    }
}
