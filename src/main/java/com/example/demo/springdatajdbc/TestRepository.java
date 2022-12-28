package com.example.demo.springdatajdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor

@Repository
public class TestRepository {

    private final JdbcTemplate jdbcTemplate;

    private static final String CREATE_ENTRY_SQL = """
            INSERT INTO test (client_id, schedule_id) VALUES (?, ?)
            """;

    private static final String GET_BY_CLIENT_ID_AND_SCHEDULE_ID_SQL = """
            SELECT id,
                   client_id,
                   schedule_id
            FROM test
            WHERE client_id = ? AND schedule_id = ?
            """;

    public int createTest(Test test) {
        return jdbcTemplate.update(CREATE_ENTRY_SQL,
                test.getClientId(),
                test.getScheduleId());
    }

    public Test getByClientIdAndScheduleId(Long clientId, String scheduleId) {
        try {
            return jdbcTemplate.queryForObject(
                    GET_BY_CLIENT_ID_AND_SCHEDULE_ID_SQL,
                    (rs, rowNum) -> new Test(
                            rs.getLong("ID"),
                            rs.getLong("CLIENT_ID"),
                            rs.getString("SCHEDULE_ID")),
                    clientId,
                    scheduleId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public List<Test> getShort(Long clientId, String scheduleId) {
        try {
            return jdbcTemplate.query(
                    GET_BY_CLIENT_ID_AND_SCHEDULE_ID_SQL,
                    (rs, rowNum) -> new Test(
                            rs.getLong("ID"),
                            rs.getLong("CLIENT_ID")),
                    clientId,
                    scheduleId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
