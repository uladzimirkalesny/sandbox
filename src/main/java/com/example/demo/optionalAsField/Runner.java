package com.example.demo.optionalAsField;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class Runner {
    public static void main(String[] args) throws JsonProcessingException {
        Book book = new Book("TestBook", 42, Optional.of("Agenda for TestBook is present"));
//        Book book = new Book("TestBook", 42, "Agenda for TestBook is present"); // string agenda
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(book));

        String bookJson = "{ \"name\": \"Oliver Twist\", \"noOfPages\": 42, \"agenda\": \"Agenda\" }"; // string agenda
//        String bookJson = "{ \"name\": \"Oliver Twist\", \"noOfPages\": 42, \"agenda\": { \"empty\": false, \"present\": true }\" }";
        Book book1 = mapper.readValue(bookJson, Book.class);
        System.out.println(book1);
    }
}
