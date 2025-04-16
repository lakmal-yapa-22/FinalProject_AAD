package com.example.backend.service;

import com.example.backend.dto.EssayResultDTO;
import com.example.backend.entity.EssayResult;
import com.example.backend.entity.Exam;
import com.example.backend.entity.User;

import java.util.List;

public interface EssayResultService {
    void saveEssayResult(EssayResultDTO essayResultDTO);



   List<EssayResultDTO> getAllEssayAnswer();


  List<EssayResult> getExamIdandUserId(Exam examId, User userId);

    EssayResult updateResult(EssayResultDTO essayResultDTO);


    List<EssayResult> getResult(String examName, User userId);
}
