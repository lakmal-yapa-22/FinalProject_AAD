package com.example.backend.controller;

import com.example.backend.dto.ExamDTO;
import com.example.backend.dto.McqQuestionDTO;
import com.example.backend.dto.UserDTO;
import com.example.backend.entity.Exam;
import com.example.backend.entity.Mcq_Question;
import com.example.backend.entity.User;
import com.example.backend.service.impl.ExamServiceImpl;
import com.example.backend.service.impl.MCQServiceImpl;
import com.example.backend.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/v1/mcq")
public class MCQController {

    @Autowired
    private MCQServiceImpl mcqService;

    @Autowired
    private ExamServiceImpl examService;
    @GetMapping("getAll")
    public List<ExamDTO> getAllExams() {
        List<ExamDTO> exam = examService.allExams();
        return exam;
    }

    @GetMapping("getAllMcq")
    public List<McqQuestionDTO> getAllMcq() {
        List<McqQuestionDTO> mcq = mcqService.allMcq();
        return mcq;
    }




    @PostMapping(path="save")
    public ResponseUtil saveMcq(@RequestBody McqQuestionDTO mcqQuestionDTO) {
        mcqService.saveMcq(mcqQuestionDTO);
        return new ResponseUtil(201,"mcq is saved",null);
    }


//    @GetMapping("getByExamId/{id}")
//    public Optional<Mcq_Question> getExamByMcqId(@PathVariable int id) {
//        Optional<Mcq_Question> mcq=mcqService.getExamMcqId(id);
//        return mcq;
//    }

    @GetMapping("/getByExamId/{id}")
    public ResponseEntity<Optional<List<Mcq_Question>>> getExamMcqById(@PathVariable int id) {
        Optional<List<Mcq_Question>> mcqs = mcqService.getExamMcqId(id);
        if (mcqs.isPresent()) {
            return ResponseEntity.ok(mcqs);
        } else {
            return ResponseEntity.notFound().build();
        }
    }





}
