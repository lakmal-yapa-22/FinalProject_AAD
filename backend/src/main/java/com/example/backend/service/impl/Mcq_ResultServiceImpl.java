package com.example.backend.service.impl;

import com.example.backend.dto.MCQResultDTO;
import com.example.backend.entity.McqResult;
import com.example.backend.entity.User;
import com.example.backend.repo.MCQResultRepo;
import com.example.backend.service.Mcq_resultService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Mcq_ResultServiceImpl implements Mcq_resultService {

    @Autowired
    private MCQResultRepo mcqResultRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void saveMcqResult(MCQResultDTO mcqResultDTO) {
        if (mcqResultRepo.existsById(mcqResultDTO.getResultId())){
            throw new RuntimeException("mcq result already exists");
        }
        McqResult mcqResult = modelMapper.map(mcqResultDTO, McqResult.class);
        mcqResultRepo.save(mcqResult);

    }
    @Override
    public List<McqResult> getResult(String examName, Long userId) {
        return mcqResultRepo.findMarksByExamNameAndUserId(examName, userId);
    }



}
