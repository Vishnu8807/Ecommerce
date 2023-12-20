package com.vishnu.userService.dtos;

import lombok.Data;

@Data
public class LogOutRequestDto {
    //why token and userId???
    private String token;
    private String userId;
}
