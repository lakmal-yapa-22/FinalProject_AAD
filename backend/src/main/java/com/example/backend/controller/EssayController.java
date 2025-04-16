package com.example.backend.controller;

import com.example.backend.dto.EssayQuestionDTO;
import com.example.backend.dto.ExamDTO;
import com.example.backend.dto.UserDTO;
import com.example.backend.entity.Essay_Question;
import com.example.backend.entity.Mcq_Question;
import com.example.backend.entity.User;
import com.example.backend.service.impl.EssayServiceImpl;
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
@RequestMapping(value = "api/v1/essay")
public class EssayController {
    @Autowired
    private EssayServiceImpl essayService;
    @Autowired
    private ExamServiceImpl examService;



    @PostMapping(path="save")
    public ResponseUtil saveEssay(@RequestBody EssayQuestionDTO essayQuestionDTO) {
        essayService.saveEssay(essayQuestionDTO);
        return new ResponseUtil(201,"user is saved",null);
    }

    @GetMapping("getAll")
    public List<ExamDTO> getAllExams() {
        List<ExamDTO> exam = examService.allExams();
        return exam;
    }


    @GetMapping("getAllQuestionEssay")
    public List<EssayQuestionDTO> getAllEssayQuestion() {
        List<EssayQuestionDTO> examQuestion = essayService.allExamQuestions();
        return examQuestion;
    }
    @GetMapping("/getByExamId/{id}")
    public ResponseEntity<Optional<List<Essay_Question>>> getExamEssayById(@PathVariable int id) {
        Optional<List<Essay_Question>> essayQuestions = essayService.getExamEssayId(id);
        if (essayQuestions.isPresent()) {
            return ResponseEntity.ok(essayQuestions);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("getMcqId/{questionNumber}")
    public Optional<Essay_Question> getExamQuestionId(@PathVariable int questionNumber) {
        Optional<Essay_Question> examQuestionId=essayService.getExamId(questionNumber);
        return examQuestionId;
    }
    @PutMapping(path = "update")
    public ResponseEntity<ResponseUtil> updateEssay(@RequestBody EssayQuestionDTO essayQuestionDTO) {
      Essay_Question essayQuestion=  essayService.updateQuestion(essayQuestionDTO);


        if (essayQuestion != null) {
            return ResponseEntity.ok(new ResponseUtil(200, "question updated", essayQuestion));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseUtil(400, "question update failed. Invalid details provided.", null));
        }
    }




}
