package com.vishnu.userService.dtos;

import com.vishnu.userService.models.Role;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class GenericUserDto {
    private String email;
    private Set<Role> roles = new HashSet<>();
}
