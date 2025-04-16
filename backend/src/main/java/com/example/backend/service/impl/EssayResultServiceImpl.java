package com.example.backend.service.impl;

import com.example.backend.dto.*;
import com.example.backend.entity.EssayResult;
import com.example.backend.entity.Exam;
import com.example.backend.entity.User;
import com.example.backend.repo.EssayResultRepo;
import com.example.backend.repo.ExamRepo;
import com.example.backend.service.EssayResultService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class
EssayResultServiceImpl implements EssayResultService {
    @Autowired
    private EssayResultRepo essayResultRepo;

    @Autowired
    private ExamRepo examRepo;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveEssayResult(EssayResultDTO essayResultDTO) {
        if (essayResultRepo.existsById(essayResultDTO.getResultId())) {
            throw new RuntimeException("result already exists");
        }
        essayResultRepo.save(modelMapper.map(essayResultDTO, EssayResult.class));
    }




    @Override
    public List<EssayResultDTO> getAllEssayAnswer() {
        List<EssayResult> essayResults = essayResultRepo.findAll();

        // Manually mapping EssayResult to EssayResultDTO
        List<EssayResultDTO> essayResultDTOs = essayResults.stream().map(essayResult ->
                new EssayResultDTO(
                        essayResult.getResultId(),
                        essayResult.getUserId(),  // User entity එකේ ID එක ගන්නවා
                        essayResult.getExamId(),  // Exam entity එකේ ID එක ගන්නවා
                        essayResult.getQuestionId(),  // Question entity එකේ ID එක ගන්නවා
                        essayResult.getAnswer1(),
                        essayResult.getAnswer2(),
                        essayResult.getAnswer3(),
                        essayResult.getAnswer4(),
                        essayResult.getTotalMarks(),
                        essayResult.getObtainedMarks(),
                        essayResult.getFeedback()
                )
        ).collect(Collectors.toList());

        return essayResultDTOs;
    }

    @Override
    public List<EssayResult> getExamIdandUserId(Exam examId, User userId) {
     return    essayResultRepo.findByExamIdAndUserId(examId, userId);
    }


    @Override
    public EssayResult updateResult(EssayResultDTO essayResultDTO) {
        return essayResultRepo.findById(essayResultDTO.getResultId())
                .map(existingResult -> {
                    EssayResult updatedResult = modelMapper.map(essayResultDTO, EssayResult.class);
                    return essayResultRepo.save(updatedResult);
                })
                .orElseThrow(() -> new RuntimeException("Exam Resilt not found! Please try again."));

    }

    @Override
    public List<EssayResult> getResult(String examName, User userId) {
        return    essayResultRepo.findByExamNameAndUserId(examName, userId);
    }


}
