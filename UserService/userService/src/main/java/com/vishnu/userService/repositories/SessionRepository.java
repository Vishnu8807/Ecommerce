package com.vishnu.userService.repositories;

import com.vishnu.userService.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session,Long> {
}
