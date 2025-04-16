package com.example.backend.controller;

import com.example.backend.dto.EssayResultDTO;
import com.example.backend.dto.EssaySummaryDTO;
import com.example.backend.dto.ExamDTO;
import com.example.backend.entity.EssayResult;
import com.example.backend.entity.Exam;
import com.example.backend.entity.McqResult;
import com.example.backend.entity.User;
import com.example.backend.service.impl.EssayResultServiceImpl;
import com.example.backend.service.impl.ExamServiceImpl;
import com.example.backend.service.impl.Mcq_ResultServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/v1/finalResult")
public class FinalResultController {

    @Autowired
    private ExamServiceImpl examService;

    @Autowired
    private Mcq_ResultServiceImpl mcqServiceResult;

    @Autowired
    private EssayResultServiceImpl essayResultService;
    @GetMapping("getAll")
    public List<ExamDTO> getAllExams() {
        List<ExamDTO> exam = examService.allExams();
        return exam;
    }

    @GetMapping("getData/{examName}/{userId}")
    public List<McqResult> getExamandUserName(@PathVariable String examName, @PathVariable Long userId) {
        return mcqServiceResult.getResult(examName, userId);
    }


    @GetMapping("getEssayData/{examName}/{userId}")
    public List<EssayResult> getExamandUserNameEssay(@PathVariable String examName, @PathVariable User userId) {
        return essayResultService.getResult(examName, userId);
    }

}
