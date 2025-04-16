package com.example.backend.service.impl;

import com.example.backend.dto.ExamDTO;
import com.example.backend.dto.UserDTO;
import com.example.backend.entity.Exam;
import com.example.backend.entity.User;
import com.example.backend.repo.ExamRepo;
import com.example.backend.service.ExamService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements ExamService {


    @Autowired
    private ExamRepo examRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void addExam(ExamDTO examDTO) {
        if (examRepo.existsById(examDTO.getExamId())){
            throw new RuntimeException("Exam already exists");
        }
        Exam exam = modelMapper.map(examDTO, Exam.class);
        examRepo.save(exam);
    }











    @Override
    public List<ExamDTO> allExams() {
        return modelMapper.map(examRepo.findAll(),
                new TypeToken<List<ExamDTO>>() {}.getType());
    }

    @Override
    public Optional<Exam> getExamId(int id) {
        return examRepo.findById(id);

    }

    @Override
    public boolean deleteExam(int id) {
        examRepo.deleteById(id);
        return true;
    }



    @Override
    public Exam updateExam(ExamDTO examDTO) {
        return examRepo.findById(examDTO.getExamId())
                .map(existingUser -> {
                Exam updatedExam = modelMapper.map(examDTO, Exam.class);
                    return examRepo.save(updatedExam);
                })
                .orElseThrow(() -> new RuntimeException("Exam not found! Please try again."));

    }
}
