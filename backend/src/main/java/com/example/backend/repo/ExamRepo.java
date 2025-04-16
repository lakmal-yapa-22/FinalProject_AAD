package com.example.backend.repo;

import com.example.backend.entity.Exam;
import com.example.backend.entity.Essay_Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepo extends JpaRepository<Exam, Integer> {

}
