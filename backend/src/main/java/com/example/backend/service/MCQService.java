package com.example.backend.service;

import com.example.backend.dto.McqQuestionDTO;
import com.example.backend.entity.McqResult;
import com.example.backend.entity.Mcq_Question;
import com.example.backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface MCQService {

    void saveMcq(McqQuestionDTO mcqQuestionDTO);



    Optional<List<Mcq_Question>> getExamMcqId(int id);

    List<McqQuestionDTO> allMcq();


}
