package com.vishnu.userService.controllers;

import com.vishnu.userService.dtos.GenericUserDto;
import com.vishnu.userService.dtos.SetUserRolesRequestDto;
import com.vishnu.userService.services.UserServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserServiceInterface userServiceInterface;

    public UserController(UserServiceInterface userServiceInterface) {
        this.userServiceInterface =  userServiceInterface;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericUserDto> getUserDetails(@PathVariable Long id) {
        GenericUserDto genericUserDto = userServiceInterface.getUserDetails(id);
        return new ResponseEntity<>(genericUserDto, HttpStatus.OK);
    }


    @PostMapping("/{id}/roles")
    public ResponseEntity<GenericUserDto> setUserRoles(@PathVariable("id") Long userId, @RequestBody SetUserRolesRequestDto request) {

        GenericUserDto genericUserDto = userServiceInterface.setUserRoles(userId, request.getRoleIds());

        return new ResponseEntity<>(genericUserDto, HttpStatus.OK);
    }
}
