package com.vishnu.userService.dtos;

import lombok.Data;

@Data
public class LogInRequestDto {
    private String email;
    private String password;
}
