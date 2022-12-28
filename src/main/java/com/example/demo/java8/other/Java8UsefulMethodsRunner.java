package com.example.demo.java8.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Java8UsefulMethodsRunner {
    public static void main(String[] args) {
        // removeIf - removes elements from a collection by a given condition in the form of Predicate.
        Collection<String> names = new ArrayList<>(Arrays.asList("Mnemonic", "Deckard", "Flynn"));
        names.removeIf(name -> name.length() > 5);


        // toArray  accepts a function in the Collection interface and takes an IntFunction as a parameter. This function accepts a parameter of the int type named size to initialize an array
        Collection<String> names1 = Arrays.asList("Mnemonic", "Deckard", "Flynn");
        String[] namesArray1 = names1.toArray(size -> new String[size]);
        String[] namesArray2 = names1.toArray(String[]::new);


        // replaceAll() 1 method takes a UnaryOperator to transform each element of the list and then replace it with the transformation result
        List<String> names2 = new ArrayList<>(List.of("Johnny Mnemonic", "Rick Deckard", "Kevin Flynn"));
        names2.replaceAll(name -> name.split(" ")[1]);

        // replaceAll() method takes a BiFunction to accept the key and value of each entry, combine them, and use the result to replace the value of the entry.
        Map<String, String> names3 = new TreeMap<>(Map.of(
                "Johnny", "Mnemonic",
                "Rick", "Deckard",
                "Kevin", "Flynn"));
        names3.replaceAll((firstname, lastname) -> firstname.charAt(0) + ". " + lastname);


        // merge() allows you to combine initializing and updating of an entry into a single operation.
        // It attempts to perform as the put() method of a given key and value.
        // If the given key is already present, the method applies the given mergeFunction to combine old and new values.
        String[] names4 = {"Johnny", "Rick", "Johnny", "Kevin", "Johnny", "Rick"};
        Map<String, Integer> namesCount4 = new TreeMap<>();
        for (String name : names4) {
            namesCount4.merge(name, 1, (oldCount, newValue) -> oldCount + newValue);
        }


        // compute() takes a key and the remapping BiFunction, which accepts two parameters—the key value and the old value.
        String[] names5 = {"Johnny", "Rick", "Johnny", "Kevin", "Johnny", "Rick"};
        Map<String, Integer> namesCount5 = new TreeMap<>();
        for (String name : names5) {
            namesCount5.compute(name, (key, count) -> count == null ? 1 : count + 1);
        }


        // computeIfAbsent() allows you to get the current value by key or to compute it with the given function, which takes the key as a parameter.
        List<String> names6 = List.of("Johnny Mnemonic", "Rick Deckard", "Johnny Silverhand", "Kevin Flynn", "Rick Streetkid");
        Map<String, List<String>> grouped6 = new TreeMap<>();
        for (String name : names6) {
            String[] nameTokens = name.split(" ");
            String firstname = nameTokens[0];
            String lastname = nameTokens[1];
            grouped6.computeIfAbsent(firstname, fname -> new ArrayList<>())
                    .add(lastname);
        }


        // computeIfPresent() allows a value to be redefined for an existing key based on the key and the old value. If the given key is not present on the map, no changes are made to the map.
        List<String> names7 = List.of("Johnny Mnemonic", "Rick Deckard", "Johnny Silverhand", "Kevin Flynn", "Rick Streetkid");
        Map<String, String[]> grouped7 = new TreeMap<>(Map.of("Johnny", new String[]{}));
        for (String name : names7) {
            String[] nameTokens = name.split(" ");
            String firstname = nameTokens[0];
            String lastname = nameTokens[1];
            grouped7.computeIfPresent(firstname, (fname, lastnameArray) -> {
                String[] newLastnameArray = Arrays.copyOf(lastnameArray, lastnameArray.length + 1);
                newLastnameArray[lastnameArray.length] = lastname;
                return newLastnameArray;
            });
        }
    }
}
