package com.vishnu.userService.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Role extends BaseModel {
    private String role;
}
