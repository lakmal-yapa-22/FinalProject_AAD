package com.example.backend.controller;

import com.example.backend.dto.EssayResultDTO;
import com.example.backend.dto.UserDTO;
import com.example.backend.entity.EssayResult;
import com.example.backend.entity.Essay_Question;
import com.example.backend.entity.Exam;
import com.example.backend.entity.User;
import com.example.backend.service.impl.EssayResultServiceImpl;
import com.example.backend.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/v1/essayResults")
public class EssayResultController {

    @Autowired
    private EssayResultServiceImpl essayResultServiceImpl;




    @PostMapping(path = "save")
    public ResponseUtil saveEssayResult(@RequestBody EssayResultDTO essayResultDTO) {
       essayResultServiceImpl.saveEssayResult(essayResultDTO);
        return new ResponseUtil(201,"Essay Result is saved",null);
    }

    @GetMapping(path ="getAll")
    public ResponseUtil getAllEssayResult() {

        return new ResponseUtil(200, "success", essayResultServiceImpl.getAllEssayAnswer());
    }

    @GetMapping("getData/{examId}/{userId}")
    public List<EssayResult> getExamandUserId(@PathVariable Exam examId, @PathVariable User userId) {
        List<EssayResult> examUserId=essayResultServiceImpl.getExamIdandUserId(examId,userId);
        return examUserId;
    }

    @PutMapping(path = "update")
    public ResponseEntity<ResponseUtil> updateResult(@RequestBody EssayResultDTO essayResultDTO) {
       EssayResult essayResult = essayResultServiceImpl.updateResult(essayResultDTO);

        if (essayResult != null) {
            return ResponseEntity.ok(new ResponseUtil(200, "User updated", essayResult));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseUtil(400, "User update failed. Invalid details provided.", null));
        }
    }



}
