package com.ms.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserResDto {
    @NotNull(message = "아이디를 입력해주세요.")
    private String id;
    
    @NotNull(message = "이름을 입력해주세요.")
    private String name;

    @NotNull
    @Pattern(regexp = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$", message="올바른 전화번호를 입력해주세요." )
    private String phone;

    @NotNull
    @Pattern(regexp = "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$", message="올바른 이메일을 입력해주세요." )
    private String email;

}
