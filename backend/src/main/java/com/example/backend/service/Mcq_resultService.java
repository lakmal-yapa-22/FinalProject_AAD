package com.example.backend.service;

import com.example.backend.dto.MCQResultDTO;
import com.example.backend.entity.McqResult;
import com.example.backend.entity.User;

import java.util.List;

public interface Mcq_resultService {
    void saveMcqResult(MCQResultDTO mcqResultDTO);

    List<McqResult> getResult(String examName, Long userId);

}
