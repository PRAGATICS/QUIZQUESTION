package org.codejudge.sb.service;

import org.codejudge.sb.domain.Question;
import org.codejudge.sb.domain.Quiz;
import org.codejudge.sb.dto.QuestionRequest;
import org.codejudge.sb.dto.QuestionResponse;
import org.codejudge.sb.mapper.QuestionMapper;
import org.codejudge.sb.repository.QuestionRepository;
import org.codejudge.sb.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionMapper questionMapper;

    public QuestionResponse getQuestion(Long QuestionId) {
        return questionMapper.mapToDto(questionRepository.findByid(QuestionId));
    }

    public Question addQuestion(QuestionRequest questionRequest) {
        // TODO Auto-generated method stub
        Quiz quiz = quizRepository.findByid(questionRequest.getQuiz());
        return questionRepository.save(questionMapper.map(questionRequest, quiz));
    }

}
