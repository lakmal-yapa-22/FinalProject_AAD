package com.example.backend.service.impl;

import com.example.backend.dto.UserDTO;
import com.example.backend.entity.User;
import com.example.backend.repo.UserRepo;
import com.example.backend.service.UserService;
import com.example.backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserDetailsService,UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

//    @Override
//    public void saveUser(UserDTO userDTO) {
//        if (userRepo.existsById(userDTO.getUserId())){
//            throw new RuntimeException("user already exists");
//        }
//        User user = modelMapper.map(userDTO, User.class);
//        userRepo.save(user);
//
//    }

    @Override
    public int saveUser(UserDTO userDTO) {
        if (userRepo.existsByEmail(userDTO.getEmail())) {
            return VarList.Not_Acceptable;
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));

            userRepo.save(modelMapper.map(userDTO, User.class));
            return VarList.Created;
        }
        }






    public User authenticateUser(String email, String password) {
        User user = userRepo.findByEmailAndPassword(email, password);

        if (user == null) {
            throw new RuntimeException("User not found! Please register first.");
        }

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password! Please try again.");
        }

        return user;
    }

    @Override
    public User updateUser(UserDTO userDTO) {
        return userRepo.findById(userDTO.getUserId())
                .map(existingUser -> {
                    User updatedUser = modelMapper.map(userDTO, User.class);
                    return userRepo.save(updatedUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found! Please try again."));

    }

    @Override
    public List<UserDTO> allUser() {
        return modelMapper.map(userRepo.findAll(),
                new TypeToken<List<UserDTO>>() {}.getType());
    }

    @Override
    public Optional<User> getUserId(int id) {
        return userRepo.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
    }

    public UserDTO loadUserDetailsByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(username);
        return modelMapper.map(user,UserDTO.class);
    }
    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getUserType().toString()));
        return authorities;
    }

}