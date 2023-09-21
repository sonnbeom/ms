package com.hypeboy.hypeBoard.entity;

import com.hypeboy.hypeBoard.dto.UserDto;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "USERS")
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

//테이블 이름도 컬럼과 동일하게 이름을 설정해줘야 한다.
public class User {
    @Id
    @Column(name = "ID")
    //컬럼 네임이 테이블과 같아야 한다.
    private String id;
    @Column(name = "USER_NAME")
    private String name;
    @Column(name = "PWD")
    private String pwd;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NICKNAME")
    private String nickname;
    @Column(name = "CREATED_AT")
    @CreatedDate
    private LocalDateTime createdAt;
    @Column(name = "UPDATED_AT")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    public User(String id, String name, String pwd, String phone, String email, String nickname) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.phone = phone;
        this.email = email;
        this.nickname = nickname;
    }
    public User(UserDto userDto) {
        this.id = userDto.getId();
        this.pwd = userDto.getPwd();
        this.name = userDto.getName();
        this.phone = userDto.getPhone();
        this.email = userDto.getEmail();
        this.nickname = userDto.getNickname();
    }
    public User(String id, String pwd){
        this.id = id;
        this.pwd = pwd;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public String getBirth() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getNickname() {
        return nickname;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}