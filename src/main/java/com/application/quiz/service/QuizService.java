package com.udaan.machine.service;

import com.udaan.machine.dtos.QuizDTO;
import com.udaan.machine.exception.MCRServiceException;
import com.udaan.machine.exception.MCRServiceNotFoundException;
import com.udaan.machine.model.Question;
import com.udaan.machine.model.Quiz;
import com.udaan.machine.repository.QuestionRepository;
import com.udaan.machine.repository.QuizRepository;
import com.udaan.machine.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public List<Quiz> getAllQuizes(int page, int size) throws MCRServiceNotFoundException {
        Pageable pageable = CommonUtil.getPagination(page, size);
        Page<Quiz> pageData = quizRepository.findAll(pageable);
        List<Quiz> quizzes = new ArrayList<>();
        if(pageData.hasContent()){
            quizzes = pageData.getContent();
        }
        else{
            throw new MCRServiceNotFoundException("No quizes found");
        }
        return quizzes;
    }

    public Quiz createQuiz(QuizDTO quizDTO) throws MCRServiceException{
        List<Question> questions = questionRepository.findAllByIdIn(quizDTO.getIds());
        Quiz quiz = new Quiz();
        quiz.setName(quizDTO.getName());
        quiz.setQuestions(questions);
        return quizRepository.save(quiz);
    }

}
