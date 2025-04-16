package com.example.backend.repo;

import com.example.backend.controller.EssayController;
import com.example.backend.entity.Essay_Question;
import jakarta.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EssayRepo extends JpaRepository<Essay_Question, Integer> {
    Optional<Essay_Question> findByQuestionNumber(int id);

    Optional<List<Essay_Question>> findByExam_ExamId(int id);
}
