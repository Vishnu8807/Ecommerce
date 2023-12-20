package com.vishnu.userService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseModel{
    private String email;
    private String encPassword;
    @ManyToMany
    private Set<Role> roles = new HashSet<>();
}
