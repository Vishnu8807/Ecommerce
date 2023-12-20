package com.vishnu.userService.services;

import com.vishnu.userService.dtos.GenericUserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServiceInterface {

    GenericUserDto getUserDetails(Long id);

    GenericUserDto setUserRoles(Long userId, List<Long> roleIds);
}
