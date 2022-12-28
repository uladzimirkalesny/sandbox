package com.example.demo.springdatajdbc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j

@RestController
@RequestMapping("/tests")
public class TestController {

    private final TestRepository testRepository;

    @PostMapping
    public String createTest(@RequestBody Test test) {
        var row = testRepository.createTest(test);
        return String.format("Insert into database %d row", row);
    }

    @GetMapping("clients/{clientId}/schedules/{scheduleId}")
    public ResponseEntity<Test> getByClientIdAndScheduleId(@PathVariable("clientId") Long clientId, @PathVariable("scheduleId") String scheduleId) {
        ResponseEntity<Test> responseEntity = Optional.ofNullable(testRepository.getByClientIdAndScheduleId(clientId, scheduleId))
                .map(test -> ResponseEntity.ok().body(test))
                .orElseGet(() -> ResponseEntity.notFound().build());
        log.info("to be done = " + responseEntity.getBody());
        return responseEntity;
    }

    @GetMapping("clients/{clientId}/schedules/{scheduleId}/list")
    public ResponseEntity<Test> getShort(@PathVariable("clientId") Long clientId, @PathVariable("scheduleId") String scheduleId) {
        List<Test> testList = testRepository.getShort(clientId, scheduleId);
        ResponseEntity<Test> responseEntity = testList.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok().body(testList.get(0));
        log.info("resp :::::: " + responseEntity.getBody());
        return responseEntity;
    }
}
