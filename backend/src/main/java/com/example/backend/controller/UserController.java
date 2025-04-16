package com.example.backend.controller;

import com.example.backend.dto.AuthDTO;
import com.example.backend.dto.ResponseDTO;
import com.example.backend.dto.UserDTO;
import com.example.backend.dto.UserLoginDTO;
import com.example.backend.entity.Exam;
import com.example.backend.entity.User;
import com.example.backend.service.impl.UserServiceImpl;
import com.example.backend.util.JwtUtil;
import com.example.backend.util.ResponseUtil;
import com.example.backend.util.VarList;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/v1/user")

public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private JwtUtil jwtUtil;




//    @PostMapping("/login")
//    public ResponseUtil login(@RequestBody UserLoginDTO loginDTO) {
//        User user = userService.authenticateUser(loginDTO.getEmail(), loginDTO.getPassword());
//        if (user != null) {
//            return new ResponseUtil(200, "Login Successful!", user);
//        } else {
//            return new ResponseUtil(401, "Invalid Email or Password", null);
//        }
//    }
    @PutMapping(path = "update")
    public ResponseEntity<ResponseUtil> updateUser(@RequestBody UserDTO userDTO) {
        User user = userService.updateUser(userDTO);

        if (user != null) {
            return ResponseEntity.ok(new ResponseUtil(200, "User updated", user));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseUtil(400, "User update failed. Invalid details provided.", null));
        }
    }


    @GetMapping("getAll")
    public List<UserDTO> getAllUsers() {
        List<UserDTO> user = userService.allUser();
        return user;
    }

    @GetMapping("getUserId/{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        Optional<User> user=userService.getUserId(id);
        return user;
    }
    @PostMapping(value = "/register")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody @Valid UserDTO userDTO) {
        try {
            int res = userService.saveUser(userDTO);
            switch (res) {
                case VarList.Created -> {
                    String token = jwtUtil.generateToken(userDTO);
                    AuthDTO authDTO = new AuthDTO();
                    authDTO.setEmail(userDTO.getEmail());
                    authDTO.setToken(token);
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, "Success", authDTO));
                }
                case VarList.Not_Acceptable -> {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Not_Acceptable, "Email Already Used", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }




}
