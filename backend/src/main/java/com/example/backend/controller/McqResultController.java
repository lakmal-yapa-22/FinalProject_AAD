package com.example.backend.controller;

import com.example.backend.dto.MCQResultDTO;
import com.example.backend.dto.McqQuestionDTO;
import com.example.backend.service.impl.Mcq_ResultServiceImpl;
import com.example.backend.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/v1/mcq_result")
public class McqResultController {
    @Autowired
    private Mcq_ResultServiceImpl mcq_resultService;

    @PostMapping(path="save")
    public ResponseUtil saveResult_mcq(@RequestBody MCQResultDTO mcqResultDTO) {
       mcq_resultService.saveMcqResult(mcqResultDTO);
        return new ResponseUtil(201,"mcq Result is saved",null);
    }

}
