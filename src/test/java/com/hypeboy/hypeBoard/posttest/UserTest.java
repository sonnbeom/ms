package com.hypeboy.hypeBoard.posttest;

import com.hypeboy.hypeBoard.entity.User;
import com.hypeboy.hypeBoard.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTest {
    @Autowired
    UserRepo userRepo;
    @Test
    public void test(){
        User user = new User("son", "sonny", "123", "1234","na@ver.com","beom" );
        System.out.println("check1");
        userRepo.save(user);
        System.out.println("check2");
    }
}
