package com.vishnu.userService.repositories;

import com.vishnu.userService.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
