package com.hypeboy.hypeBoard.repository;

import com.hypeboy.hypeBoard.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  {
    Optional<User> findByEmail(String email);
}
