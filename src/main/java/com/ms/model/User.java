package com.ms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id", nullable = false, length = 255)
    private String userId;

    @Column(name = "user_name", nullable = false, length = 255)
    private String userName;

    @Column(name = "phone", length = 255)
    private String phone;

    @Column(name = "email", unique = true, length = 255)
    private String email;

    @Column(name = "pwd", nullable = false, length = 255)
    private String password;

    public User() {}
}
