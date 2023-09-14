package com.hypeboy.hypeBoard.entity;

import com.hypeboy.hypeBoard.dto.UserDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
//테이블 이름도 컬럼과 동일하게 이름을 설정해줘야 한다.
public class User {
    @Id
    @Column(name = "User_ID")
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
    public User(String id, String name, String pwd, String phone, String email) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.phone = phone;
        this.email = email;
    }
    public User(){

    }

    public User(UserDto userDto) {
        this.id = userDto.getId();
        this.pwd = userDto.getPwd();
        this.name = userDto.getName();
        this.phone = userDto.getPhone();
        this.email = userDto.getEmail();
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
}
