package com.karthick.budget_manager.service;

import com.karthick.budget_manager.datarepo.UserRepository;
import com.karthick.budget_manager.dto.UserDto;
import com.karthick.budget_manager.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    private UserDto convertEntityToDto(Optional<User> user) {
        return (new ModelMapper()).map(user, UserDto.class);
    }

    public UserDto getUserById(int id) {
        return convertEntityToDto(userRepo.findById(id));
    }

    public UserDto getUserByEmail(String email) {
        return convertEntityToDto(userRepo.findByEmail(email));
    }
}
