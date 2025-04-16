package com.example.backend.repo;

import com.example.backend.dto.EssayResultDTO;
import com.example.backend.dto.EssaySummaryDTO;
import com.example.backend.entity.EssayResult;
import com.example.backend.entity.Exam;
import com.example.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EssayResultRepo extends JpaRepository<EssayResult, Integer> {


    List<EssayResult> findByExamIdAndUserId(Exam examId, User userId);


    List<EssayResult> findByExamNameAndUserId(String examName, User userId);
}
