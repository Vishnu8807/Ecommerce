package com.vishnu.userService.repositories;

import com.vishnu.userService.models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Optional;
import java.util.function.Function;

public interface UserServiceRepository extends JpaRepository<User, Long> {

    User findByEncPassword(String encPassword);

    Optional<User> findByEmail(String email);
}
