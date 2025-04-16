package com.example.backend.service;

import com.example.backend.dto.EssayQuestionDTO;
import com.example.backend.entity.Essay_Question;

import java.util.List;
import java.util.Optional;

public interface EssayService {
    void saveEssay(EssayQuestionDTO essayQuestionDTO);

    Optional<Essay_Question> getExamId(int id);

    Essay_Question updateQuestion(EssayQuestionDTO essayQuestionDTO);

    List<EssayQuestionDTO> allExamQuestions();

    Optional<List<Essay_Question>> getExamEssayId(int id);
}
