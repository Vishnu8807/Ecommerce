package com.vishnu.userService.services;

import com.vishnu.userService.dtos.GenericUserDto;
import com.vishnu.userService.models.User;
import com.vishnu.userService.repositories.UserServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class selfImplUserService implements UserServiceInterface {

    private UserServiceRepository userServiceRepository;

    public selfImplUserService(UserServiceRepository userServiceRepository) {
        this.userServiceRepository = userServiceRepository;
    }

    @Override
    public GenericUserDto getUserDetails(Long id) {
        Optional<User> optionalUser = userServiceRepository.findById(id);
        if(optionalUser.isEmpty()){
            return null;
        }
        User user = optionalUser.get();
        GenericUserDto genericUserDto = new GenericUserDto();
        genericUserDto.setEmail(user.getEmail());
        genericUserDto.setRoles(user.getRoles());
        return genericUserDto;
    }

    @Override
    public GenericUserDto setUserRoles(Long userId, List<Long> roleIds) {
        return null;
    }


}
