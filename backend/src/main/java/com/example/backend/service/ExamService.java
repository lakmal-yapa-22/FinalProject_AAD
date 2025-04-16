package com.example.backend.service;

import com.example.backend.dto.ExamDTO;
import com.example.backend.entity.Exam;

import java.util.List;
import java.util.Optional;

public interface ExamService {
    void addExam(ExamDTO examDTO);

    List<ExamDTO> allExams();

    Optional<Exam> getExamId(int id);

    boolean deleteExam(int id);

    Exam updateExam(ExamDTO examDTO);
}
