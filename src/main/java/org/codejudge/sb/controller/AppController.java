package org.codejudge.sb.controller;

import io.swagger.annotations.ApiOperation;
import org.codejudge.sb.domain.Question;
import org.codejudge.sb.domain.Quiz;
import org.codejudge.sb.dto.QuestionRequest;
import org.codejudge.sb.dto.QuestionResponse;
import org.codejudge.sb.dto.QuizQuestionResponse;
import org.codejudge.sb.dto.QuizReponse;
import org.codejudge.sb.service.QuestionService;
import org.codejudge.sb.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping
public class AppController {

    @Autowired
    private QuizService QuizService;

    @Autowired
    private QuestionService QuestionService;

    @ApiOperation("This is the hello world api")
    @GetMapping("/")
    public String hello() {
        return "Hello World!!";
    }

    @ApiOperation("This is to get quiz by id")
    @GetMapping("/api/quiz/{quizId}")
    public ResponseEntity<QuizReponse> quizes(@PathVariable Long quizId) {
        if (QuizService.getQuizById(quizId) == null)
            return new ResponseEntity<QuizReponse>(HttpStatus.NOT_FOUND);

        return status(HttpStatus.OK).body(QuizService.getQuizById(quizId));

    }

    @ApiOperation("This is to get question by id")
    @GetMapping("/api/questions/{QuestionId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<QuestionResponse> getQuestion(@PathVariable Long QuestionId) {
        if (QuestionService.getQuestion(QuestionId) == null)
            return new ResponseEntity<QuestionResponse>(HttpStatus.NOT_FOUND);

        return status(HttpStatus.OK).body(QuestionService.getQuestion(QuestionId));
    }

    @ApiOperation("This is to get question by id")
    @GetMapping("/api/quiz-questions/{quizId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<QuizQuestionResponse> getQuizQuestion(@PathVariable Long quizId) {
        if (QuizService.getQuizById(quizId) == null)
            return new ResponseEntity<QuizQuestionResponse>(HttpStatus.NOT_FOUND);

        return status(HttpStatus.OK).body(QuizService.getQuizQuestions(quizId));
    }

    @ApiOperation("This is to get quiz by id")
    @PostMapping(value = "/api/quiz")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createquize(@RequestBody Quiz quiz) {
        JSONObject json = new JSONObject();
        try {
            System.out.println(quiz.toString());
            QuizService.addQuiz(quiz);
            System.out.println(QuizService.getQuizById(quiz.getId()));
            if (QuizService.getQuizById(quiz.getId()) == null) {
                json.put("status", "failure");
                json.put("reason", "Quiz Id not found");
                return new ResponseEntity<>(json, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(QuizService.getQuizById(quiz.getId()), HttpStatus.CREATED);
        } catch (Exception ex) {

            System.out.println("Exception caughtt" + ex);
            json.put("status", "failure");
            json.put("reason", ex.getMessage());
            ex.printStackTrace();
            return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
        }

    }

    @ApiOperation("This is to get quiz by id")
    @PostMapping(value = "/api/questions")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createquestion(@RequestBody QuestionRequest questionRequest) {
        JSONObject json = new JSONObject();
        try {
            System.out.println(questionRequest.toString());

            Question question = QuestionService.addQuestion(questionRequest);

            return new ResponseEntity<>(QuestionService.getQuestion(question.getId()), HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println("Exception caughtt" + ex);
            json.put("status", "failure");
            json.put("reason", ex.getMessage());
            ex.printStackTrace();
            return new ResponseEntity<>(json, HttpStatus.BAD_REQUEST);
        }
    }
}
