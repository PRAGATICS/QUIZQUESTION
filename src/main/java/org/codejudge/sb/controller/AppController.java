package org.codejudge.sb.controller;


import io.swagger.annotations.ApiOperation;
import io.swagger.models.Response;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.codejudge.sb.domain.Question;
import org.codejudge.sb.domain.Quiz;
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
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity quizes(@PathVariable Long quizId) {
    	if(QuizService.getQuizById(quizId)==null)
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 
    	return new ResponseEntity<>(QuizService.getQuizById(quizId),HttpStatus.OK);
    }

    @ApiOperation("This is to get question by id")
    @GetMapping("/api/questions/{QuestionId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getQuestion(@PathVariable Long QuestionId) {
    	if(QuestionService.getQuestion(QuestionId)==null)
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	
        return new ResponseEntity<>( QuestionService.getQuestion(QuestionId),HttpStatus.OK);
    }
    
    
    @ApiOperation("This is to get quiz by id")
    @PostMapping(value="/api/quiz")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createquize(@RequestBody Quiz quiz) {
    	JSONObject json=new JSONObject();
    	try
    	{
         System.out.println(quiz.toString());
         QuizService.addQuiz(quiz);
         System.out.println(QuizService.getQuizById(quiz.getid()));
         if(QuizService.getQuizById(quiz.getid())==null)
         {
        	 json.put("status","failure");
        	 json.put("reason", "Quiz Id not found");
        	 return new ResponseEntity<>(json,HttpStatus.NOT_FOUND);
         }
        	 
         
         return new ResponseEntity<>(QuizService.getQuizById(quiz.getid()),HttpStatus.CREATED);
    	}
    	catch(Exception ex){
    		
    		System.out.println("Exception caughtt"+ex);
    		 json.put("status","failure");
        	 json.put("reason", ex.getMessage());
        	 ex.printStackTrace();
    		 return new ResponseEntity<>(json,HttpStatus.BAD_REQUEST);
    	}
    	
    }

    
   
    
    @ApiOperation("This is to get quiz by id")
    @PostMapping(value="/api/questions")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createquestion(@RequestBody Question question) {
    	JSONObject json=new JSONObject();
    	try
    	{
         System.out.println(question.toString());
         
         
         QuestionService.addQuestion(question);
       
        /* if(QuestionService.getQuestion(question.getid())==null) {
        	 json.put("status","failure");
        	 json.put("reason", "Question Id not found");
        	 return new ResponseEntity<>(json,HttpStatus.NOT_FOUND);
         }*/
         return new ResponseEntity<>( QuestionService.getQuestion(question.getId()),HttpStatus.OK);
    	}
    	catch(Exception ex)
    	{
    		System.out.println("Exception caughtt"+ex);
   		   json.put("status","failure");
       	   json.put("reason", ex.getMessage());
   		   return new ResponseEntity<>(json,HttpStatus.BAD_REQUEST);
    	}
    }
}

