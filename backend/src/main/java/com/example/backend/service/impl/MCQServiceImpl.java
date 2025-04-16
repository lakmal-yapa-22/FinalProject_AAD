package com.example.backend.service.impl;

import com.example.backend.dto.McqQuestionDTO;
import com.example.backend.entity.McqResult;
import com.example.backend.entity.Mcq_Question;
import com.example.backend.entity.User;
import com.example.backend.repo.MCQRepo;
import com.example.backend.repo.ExamRepo;
import com.example.backend.service.MCQService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MCQServiceImpl implements MCQService {

    @Autowired
    private MCQRepo mcqRepo;

    @Autowired
    private ExamRepo examRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void saveMcq(McqQuestionDTO mcqQuestionDTO) {
        if (mcqRepo.existsById(mcqQuestionDTO.getId())) {
            throw  new RuntimeException("Mcq already exists");
        }
        Mcq_Question mcqQuestion = modelMapper.map(mcqQuestionDTO, Mcq_Question.class);
        mcqRepo.save(mcqQuestion);

    }



//
//    @Override
//    public Optional<Mcq_Question> getExamMcqId(int id) {
//        return mcqRepo.findByExam_ExamId(id);
//    }

    public Optional<List<Mcq_Question>> getExamMcqId(int id) {
        return mcqRepo.findByExam_ExamId(id);
    }

    @Override
    public List<McqQuestionDTO> allMcq() {
        return modelMapper.map(mcqRepo.findAll(),
                new TypeToken<List<McqQuestionDTO>>() {}.getType());
    }





}