package com.hypeboy.hypeBoard.repository;

import com.hypeboy.hypeBoard.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class UserRepo {
    private final JdbcTemplate jdbcTemplate;

    public UserRepo(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public void save(User user){
        String sql = "INSERT INTO users (id, name, pwd, phone, email, nickname, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        int rowsInserted = jdbcTemplate.update(
                sql,
                user.getId(),
                user.getName(),
                user.getPwd(),
                user.getPhone(),
                user.getEmail(),
                user.getNickname(),
                LocalDateTime.now(),
                LocalDateTime.now()

        );

    }
}
