package com.example.demo.java8.other;

import java.util.Arrays;
import java.util.Random;

/**
 * Read about ForkJoinPool new concurrent strategy.
 * Not always be faster on small sizing arrays
 */
public class ArrayParallelSorting {
    public static void main(String[] args) {
        int[] arr1 = new int[10000000];
        int[] arr2 = new int[10000000];

        Random random = new Random();
        for (int i = 0; i < arr1.length; i++) {
            int value = random.nextInt();
            arr1[i] = value;
            arr2[i] = value;
        }

        long startParallel = System.currentTimeMillis();
        Arrays.parallelSort(arr1);
        long endParallel = System.currentTimeMillis();
        System.out.println(arr1);
        System.out.println("Parallel Sorting took : " + (endParallel - startParallel));


        long startSequential = System.currentTimeMillis();
        Arrays.sort(arr2);
        long endSequential = System.currentTimeMillis();
        System.out.println(arr2);
        System.out.println("Sequential Sorting took : " + (endSequential - startSequential));
    }
}
