package com.example.demo.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRunner {
    public static void main(String[] args) {
        String[] names = new String[]{"Joe", "Andrew", "Michael", "John"};

        System.out.println("===================Terminal Operations===================");
        Stream<String> arrayStream = Arrays.stream(names);
        arrayStream.forEach(name -> System.out.println(name));

        Comparator<String> stringComparator = (firstElement, secondElement) -> firstElement.compareTo(secondElement);

        Optional<String> minElement = Arrays.stream(names).min(stringComparator);
        String minElementAsString = minElement.orElse(null);
        System.out.println("Min element as a string: " + minElementAsString);

        Optional<String> maxElement = Arrays.stream(names).max(stringComparator);
        String maxElementAsString = maxElement.orElse(null);
        System.out.println("Max element as a string: " + maxElementAsString);

        long namesCount = Arrays.stream(names).count();
        System.out.println("namesCount = " + namesCount);

        boolean areNamesEmpty = Arrays.stream(names).allMatch(name -> !name.isEmpty());
        System.out.println("areNamesEmpty = " + areNamesEmpty);

        boolean areNamesContainAndrew = Arrays.stream(names).anyMatch(name -> name.equals("Andrew"));
        System.out.println("areNamesContainAndrew = " + areNamesContainAndrew);

        boolean isMaxNonExists = Arrays.stream(names).noneMatch(name -> name.equals("Max"));
        System.out.println("isMaxNonExists = " + isMaxNonExists);

        Stream<String> listStream = Arrays.asList(names).stream();
        Stream<Integer> generateStream = Stream.generate(() -> 5);
        Stream<Integer> iterateStream = Stream.iterate(1, x -> x + 2);

        List<String> collect = listStream.collect(Collectors.toList());
        System.out.println("collect = " + collect);

        int[] ints = new int[]{1, 2, 3};
        OptionalInt optionalTotal = Arrays.stream(ints).reduce((x, y) -> x + y);
        System.out.println("optionalTotal.getAsInt = " + optionalTotal.getAsInt());

        int total = Arrays.stream(ints).reduce(10, (x, y) -> x + y);
        System.out.println("total = " + total);

        System.out.println("===================Intermediate Operations===================");
        List<String> nameList = Arrays.asList(names);
        String[] upperCaseNames = new String[]{"Nick", "Alex"};

        nameList.stream()
                .filter(name -> name.startsWith("J"))
                .forEach(System.out::println);

        List<String> upperCaseNameList = nameList.stream()
                .map(name -> name.toUpperCase())
                .peek(name -> System.out.println("upper case name = " + name))
                .collect(Collectors.toList());

        Stream.of(nameList, upperCaseNameList)
                .flatMap(List::stream)
                .map(name -> name.toLowerCase())
                .forEach(System.out::println);
        /*String[] strings = Stream.of(names, upperCaseNames)
                .flatMap(array -> Stream.of(array))
                .toArray(size -> new String[size]);
        for (String string : strings) {
            System.out.println(string);
        }*/

        nameList.stream()
                .skip(2)
                .forEach(name -> System.out.println("skip : " + name));

        nameList.stream()
                .limit(1)
                .forEach(name -> System.out.println("limit : " + name));

        nameList.stream()
                .distinct()
                .forEach(System.out::println);

        nameList.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
