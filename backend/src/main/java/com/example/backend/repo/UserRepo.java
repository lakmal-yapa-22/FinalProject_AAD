package com.example.backend.repo;

import com.example.backend.dto.UserDTO;
import com.example.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email); // Check if a user with the given email exists
    boolean existsByNic(String nic);

    User findByEmail(String userName);

}
