package com.example.demo.optionalAsField;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String name;
    private Integer noOfPages;
    private Optional<String> agenda;
//    private String agenda;
}
