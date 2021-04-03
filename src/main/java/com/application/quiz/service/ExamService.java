package com.udaan.machine.service;

import com.udaan.machine.dtos.ExamResponseDTO;
import com.udaan.machine.dtos.QuestionResponseDTO;
import com.udaan.machine.exception.MCRServiceNotFoundException;
import com.udaan.machine.model.Exam;
import com.udaan.machine.model.ExamResponse;
import com.udaan.machine.model.Question;
import com.udaan.machine.model.Quiz;
import com.udaan.machine.repository.ExamRepository;
import com.udaan.machine.repository.QuestionRepository;
import com.udaan.machine.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public void saveResponse(ExamResponseDTO examResponseDTO) throws MCRServiceNotFoundException {
        List<ExamResponse> examResponses = new ArrayList<>();
        Optional<Quiz> quizInDB = quizRepository.findById(examResponseDTO.getQuizId());
        Quiz quiz = new Quiz();
        if (quizInDB.isPresent()) {
            quiz = quizInDB.get();
        } else {
            throw new MCRServiceNotFoundException("Quiz id not found");
        }
        Exam exam = new Exam();
        for (QuestionResponseDTO questionResponseDTO : examResponseDTO.getQuestionResponseDTOList()) {
            ExamResponse examResponse = new ExamResponse();
            Optional<Question> questionInDB = questionRepository.findById(questionResponseDTO.getQuestionId());
            Question question = new Question();
            if (questionInDB.isPresent()) {
                question = questionInDB.get();
            } else {
                throw new MCRServiceNotFoundException("question id not found");
            }
            examResponse.setQuiz(quiz);
            examResponse.setQuestion(question);
            examResponse.setResponse(questionResponseDTO.getResponse());
            examResponses.add(examResponse);
        }
        exam.setExamResponses(examResponses);
        examRepository.save(exam);
    }
}
