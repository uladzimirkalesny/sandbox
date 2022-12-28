package com.example.demo;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Foo> fooList = new ArrayList<>();
        fooList.add(new Foo("Proposed", "1"));
        fooList.add(new Foo("Live", "12"));
        System.out.println(fooList);


        fooList = extracted(fooList);
        System.out.println(fooList);
    }

    private static List<Foo> extracted(List<Foo> fooList) {
        fooList.forEach(foo -> {
            List<Integer> integers;
            if (foo.getStatus().equals("Proposed")) {
                integers = List.of(1);
            } else {
                integers = List.of(12);
            }
            foo.setList(integers);
        });
        return fooList;
    }
}

@Getter
@ToString
class Foo {
    String status;
    String value;
    List<Integer> list = new ArrayList<>();

    public Foo(String status, String value) {
        this.status = status;
        this.value = value;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
