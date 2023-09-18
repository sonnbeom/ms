package com.hypeboy.hypeBoard.dto;


import lombok.NoArgsConstructor;
import lombok.ToString;



@ToString
@NoArgsConstructor
public class UserDto {
    private String id;
    private String name;
    private String pwd;
    private String phone;
    private String email;
    private String nickname;
    public UserDto(String id, String name, String pwd, String phone, String email, String nickname) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.phone = phone;
        this.email = email;
        this.nickname = nickname;
    }
    public UserDto(String id, String pwd){
        this.id = id;
        this.pwd = pwd;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}