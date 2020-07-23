package org.codejudge.sb.service;

import org.codejudge.sb.domain.Question;
import org.codejudge.sb.domain.Quiz;
import org.codejudge.sb.dto.QuestionResponse;
import org.codejudge.sb.dto.QuizQuestionResponse;
import org.codejudge.sb.dto.QuizReponse;
import org.codejudge.sb.mapper.QuestionMapper;
import org.codejudge.sb.mapper.QuizMapper;
import org.codejudge.sb.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Service
public class QuizService {

    @Autowired
    private QuizRepository QuizRepository;

    @Autowired
    private QuizMapper quizMapper;

    @Autowired
    private QuestionMapper questionMapper;

    public QuizReponse getQuizById(Long quizId) {

        return quizMapper.mapToDto(QuizRepository.findByid(quizId));

    }

    public QuizQuestionResponse getQuizQuestions(Long quizId) {
        List<QuestionResponse> questionResponseList = new ArrayList<>();

        Quiz quiz = QuizRepository.findByid(quizId);

        QuizQuestionResponse quizQuestionResponse = new QuizQuestionResponse();

        quizQuestionResponse.setName(quiz.getName());
        quizQuestionResponse.setDescription(quiz.getDescription());

        List<Question> questionList = quiz.getQuestions();

        for (Question question : questionList) {
            QuestionResponse questionResponse = questionMapper.mapToDto(question);
            questionResponseList.add(questionResponse);
        }
        quizQuestionResponse.setQuestions(questionResponseList);

        return quizQuestionResponse;
    }

    public void addQuiz(@Valid Quiz quiz) {
        System.out.println(quiz);
        QuizRepository.save(quiz);
    }

}
