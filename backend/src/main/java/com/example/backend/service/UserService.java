package com.example.backend.service;

import com.example.backend.dto.UserDTO;
import com.example.backend.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {
    int saveUser(UserDTO userDTO);

    User authenticateUser(String email, String password);

    User updateUser(UserDTO userDTO);


    List<UserDTO> allUser();

    Optional<User> getUserId(int id);

    UserDetails loadUserByUsername(String email);

    UserDTO loadUserDetailsByUsername(String email);
}
