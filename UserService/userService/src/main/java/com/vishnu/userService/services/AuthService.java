package com.vishnu.userService.services;

import com.vishnu.userService.dtos.GenericUserDto;
import com.vishnu.userService.models.Session;
import com.vishnu.userService.models.SessionStatus;
import com.vishnu.userService.models.User;
import com.vishnu.userService.repositories.SessionRepository;
import com.vishnu.userService.repositories.UserServiceRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private UserServiceRepository userServiceRepository;
    private SessionRepository sessionRepository;

    public AuthService(UserServiceRepository userServiceRepository,SessionRepository sessionRepository) {
        this.userServiceRepository = userServiceRepository;
        this.sessionRepository = sessionRepository;
    }

    public GenericUserDto loginUser(String email,String password) {
        Optional<User> optionalUser = userServiceRepository.findByEmail(email);
        if(optionalUser.isEmpty()) {
            return null;
        }

        User user = optionalUser.get();

        if(!password.equals(user.getEncPassword())) {
            return null;
        }

        String token = RandomStringUtils.randomAlphanumeric(30);

        //create a new session with token
        Session session = new Session();
        session.setToken(token);
        session.setUser(user);
        session.setSessionStatus(SessionStatus.Active);
        sessionRepository.save(session);

        GenericUserDto genericUserDto = new GenericUserDto();
        genericUserDto.setEmail(user.getEmail());
        return genericUserDto;
    }

    public GenericUserDto signUp(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setEncPassword(password);

        userServiceRepository.save(user);
        GenericUserDto genericUserDto = new GenericUserDto();
        genericUserDto.setEmail(user.getEmail());
        return genericUserDto;
    }

    public ResponseEntity<Void> logOut(Long userId) {
        Optional<Session> optionalSession = sessionRepository.findById(userId);
        if(optionalSession.isEmpty()) {
            return null;
        }
        Session session = optionalSession.get();
        session.setSessionStatus(SessionStatus.Ended);
        sessionRepository.save(session);
        return ResponseEntity.ok().build();
    }

    public String validateToken() {
        return null;
    }
}
