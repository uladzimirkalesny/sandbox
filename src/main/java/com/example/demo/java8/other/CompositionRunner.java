package com.example.demo.java8.other;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class CompositionRunner {
    protected static class Employee {
        private String name;
        private Integer age;
        private String jobTitle;
        private Float salary;

        public Employee(String name, Integer age, String jobTitle, Float salary) {
            this.name = name;
            this.age = age;
            this.jobTitle = jobTitle;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        Function<Integer, Integer> timesTwo = x -> x * 2;
        Function<Integer, Integer> minusOne = x -> x - 1;
        Function<Integer, Integer> timeTwoMinus1 = minusOne.compose(timesTwo);
        Function<Integer, Integer> timeTwoMinus2 = timesTwo.andThen(minusOne);

        Assert.isTrue(19 == timeTwoMinus1.apply(10), "Result equals 19");
        Assert.isTrue(19 == timeTwoMinus2.apply(10), "Result equals 19");

        Employee[] employeeArray = {
                new Employee("John", 34, "developer", 80000F),
                new Employee("Hannah", 24, "developer", 95000F),
                new Employee("Bart", 50, "sales executive", 100000F),
                new Employee("Sophie", 49, "construction worker", 40000F),
                new Employee("Darren", 38, "writer", 50000F),
                new Employee("Nancy", 29, "developer", 75000F)
        };
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(employeeArray));

        Function<Employee, String> getNameFunction = employee -> employee.name;
        Function<String, String> reverseNameFunction = name -> new StringBuilder(name).reverse().toString();
        Function<String, String> uppercaseName = String::toUpperCase;

        Function<Employee, String> getReversedUppercaseName = getNameFunction
                .andThen(reverseNameFunction)
                .andThen(uppercaseName);

        employeeList.stream()
                .map(getReversedUppercaseName)
                .forEach(System.out::println);
    }
}
