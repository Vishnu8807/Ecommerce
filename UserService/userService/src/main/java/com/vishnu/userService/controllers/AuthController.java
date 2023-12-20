package com.vishnu.userService.controllers;

import com.vishnu.userService.dtos.GenericUserDto;
import com.vishnu.userService.dtos.LogInRequestDto;
import com.vishnu.userService.dtos.SignUpRequestDto;
import com.vishnu.userService.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


//    private ResponseEntity<String> createUser(@RequestBody GenericUser user) {
//
//    }

    @PostMapping("/Users")
    private ResponseEntity<GenericUserDto> signUp(@RequestBody SignUpRequestDto requestDto) {
        GenericUserDto genericUserDto = authService.signUp(requestDto.getEmail(),requestDto.getPassword());
        return new ResponseEntity<>(genericUserDto, HttpStatus.OK);
    }

    @PostMapping("/login")
    private ResponseEntity<GenericUserDto> loginUser(@RequestBody LogInRequestDto requestDto) {
        GenericUserDto genericUserDto = authService.loginUser(requestDto.getEmail(),requestDto.getPassword());
        return new ResponseEntity<>(genericUserDto,HttpStatus.OK);
    }

    @PostMapping("/logout/{id}")
    private ResponseEntity<Void> logoutUser(@PathVariable Long id) {
        return authService.logOut(id);
    }


    @PostMapping("/Validate")
    private ResponseEntity<String> validateToken() {
        String ans = authService.validateToken();
        return new ResponseEntity<>(ans,HttpStatus.OK);
    }
}
