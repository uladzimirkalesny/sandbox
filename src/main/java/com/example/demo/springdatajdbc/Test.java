package com.example.demo.springdatajdbc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    private Long id;
    private Long clientId;
    private String scheduleId;

    public Test(Long id, Long clientId) {
        this.id = id;
        this.clientId = clientId;
    }
}
