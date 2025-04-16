package com.example.backend.repo;

import com.example.backend.entity.McqResult;
import com.example.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MCQResultRepo extends JpaRepository<McqResult, Integer> {



        @Query(value = "SELECT * FROM msq_results WHERE exam_name = :examName AND user_id = :userId", nativeQuery = true)
        List<McqResult> findMarksByExamNameAndUserId(@Param("examName") String examName, @Param("userId") Long userId);
    }
