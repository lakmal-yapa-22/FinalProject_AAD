package com.example.backend.service.impl;

import com.example.backend.dto.EssayQuestionDTO;
import com.example.backend.dto.ExamDTO;
import com.example.backend.dto.McqQuestionDTO;
import com.example.backend.dto.UserDTO;
import com.example.backend.entity.Essay_Question;
import com.example.backend.entity.Exam;
import com.example.backend.entity.Mcq_Question;
import com.example.backend.entity.User;
import com.example.backend.repo.EssayRepo;
import com.example.backend.service.EssayService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EssayServiceImpl implements EssayService {
@Autowired
private EssayRepo essayRepo;
@Autowired
private ModelMapper modelMapper;


    @Override
    public void saveEssay(EssayQuestionDTO essayQuestionDTO) {
        if (essayRepo.existsById(essayQuestionDTO.getId())) {
            throw  new RuntimeException("Mcq already exists");
        }
      Essay_Question essayQuestion = modelMapper.map(essayQuestionDTO, Essay_Question.class);
        essayRepo.save(essayQuestion);

    }

    @Override
    public Optional<Essay_Question> getExamId(int id) {
       return essayRepo.findByQuestionNumber(id);
    }

    @Override
    public Essay_Question updateQuestion(EssayQuestionDTO essayQuestionDTO) {
        return essayRepo.findById(essayQuestionDTO.getId())
                .map(existingUser -> {
                   Essay_Question essayQuestion = modelMapper.map(essayQuestionDTO, Essay_Question.class);
                    return essayRepo.save(essayQuestion);
                })
                .orElseThrow(() -> new RuntimeException("question not found! Please try again."));

    }

    @Override
    public List<EssayQuestionDTO> allExamQuestions() {
        return modelMapper.map(essayRepo.findAll(),
                new TypeToken<List<ExamDTO>>() {}.getType());
    }

    @Override
    public Optional<List<Essay_Question>> getExamEssayId(int id) {
        return essayRepo.findByExam_ExamId(id);
    }






}
