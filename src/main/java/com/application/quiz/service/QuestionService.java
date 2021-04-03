package com.udaan.machine.service;

import com.udaan.machine.dtos.QuestionDTO;
import com.udaan.machine.model.Question;
import com.udaan.machine.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question createQuestion(QuestionDTO questionDTO){
        Question question = new Question();
        question.setDescription(questionDTO.getDescription());
        question.setOptions(questionDTO.getOptions());
        question.setAnswer(questionDTO.getAnswer());
        return questionRepository.save(question);
    }
}
