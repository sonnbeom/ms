package com.hypeboy.hypeBoard.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@NoArgsConstructor
public class UserDto {

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String id;
    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String name;
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String pwd;
    @NotBlank(message = "핸드폰 번호 필수 입력 값입니다.")
    private String phone;
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    private String email;
    @NotBlank(message = "닉네임은 필수 입력 값입니다.")
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