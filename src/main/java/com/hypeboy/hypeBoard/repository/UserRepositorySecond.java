package com.hypeboy.hypeBoard.repository;

import com.hypeboy.hypeBoard.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepositorySecond extends CrudRepository<User, String> {
    Optional<User> findByPwd(String pwd);

}
