package com.example.backend.controller;

import com.example.backend.dto.ExamDTO;
import com.example.backend.dto.UserDTO;
import com.example.backend.entity.Exam;
import com.example.backend.entity.User;
import com.example.backend.service.impl.ExamServiceImpl;
import com.example.backend.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/v1/exam")
public class ExamController {

    @Autowired
    private ExamServiceImpl examService;

    @PostMapping("save")
    public ResponseUtil saveExam(@RequestBody ExamDTO examDTO) {
        examService.addExam(examDTO);
        return new ResponseUtil(201,"user is saved",null);
    }




    @GetMapping("getAll")
    public List<ExamDTO> getAllExams() {
        List<ExamDTO> exam = examService.allExams();
        return exam;
    }

    @GetMapping("getExamId/{id}")
    public Optional<Exam> getExamById(@PathVariable int id) {
        Optional<Exam> exam=examService.getExamId(id);
        return exam;
    }


    @DeleteMapping("delete/{id}")
    public boolean deleteExam(@PathVariable int id) {
       examService.deleteExam(id);
        return true;

    }


    @PutMapping(path = "update")
    public ResponseEntity<ResponseUtil> updateExam(@RequestBody ExamDTO examDTO) {
     Exam exam = examService.updateExam(examDTO);

        if (exam != null) {
            return ResponseEntity.ok(new ResponseUtil(200, "exam updated", exam));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseUtil(400, "exam update failed. Invalid details provided.", null));
        }
    }

}
