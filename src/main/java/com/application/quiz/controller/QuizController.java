package com.udaan.machine.controller;

import com.udaan.machine.dtos.QuizDTO;
import com.udaan.machine.exception.MCRServiceException;
import com.udaan.machine.exception.MCRServiceNotFoundException;
import com.udaan.machine.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;


    @GetMapping()
    public ResponseEntity getAllQuizes(@RequestParam int size, @RequestParam int page) throws MCRServiceException, MCRServiceNotFoundException {
          return ResponseEntity.status(HttpStatus.OK).body(quizService.getAllQuizes(size, page));
    }

    @PostMapping()
    public ResponseEntity createQuiz(@RequestBody QuizDTO quizDTO) throws MCRServiceException{
        return ResponseEntity.status(HttpStatus.OK).body(quizService.createQuiz(quizDTO));
    }
}
