package com.hypeboy.hypeBoard;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
@Repository
public class UserRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public User findById(String id) {
        User res = jdbc.queryForObject("select id, name from test_users where id = ?", this::mapRowToUser, id);
        log.info("@@@ Result: >>> " + res);
        return res;
    }

    private User mapRowToUser(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getString("id"), rs.getString("name"));
    }
}
