package com.udaan.machine.controller;

import com.udaan.machine.dtos.QuestionDTO;
import com.udaan.machine.exception.MCRServiceException;
import com.udaan.machine.model.Question;
import com.udaan.machine.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping()
    public ResponseEntity createQuestion(@RequestBody QuestionDTO questionDTO) throws MCRServiceException{
        return ResponseEntity.status(HttpStatus.OK).body(questionService.createQuestion(questionDTO));
    }
}
