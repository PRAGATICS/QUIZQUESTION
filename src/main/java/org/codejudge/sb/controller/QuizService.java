package org.codejudge.sb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.codejudge.sb.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;





@Service
public class QuizService {
	@Autowired
	private QuizRepository QuizRepository;
	public  Quiz getQuizById(Long quizId) {
		//System.out.println("Inside getAllQuizes"+QuizRepository.findById(quizId).get());
		return QuizRepository.findByid(quizId);
		
		}
	public void addQuiz(@Valid Quiz quiz) {
		// TODO Auto-generated method stub
		System.out.println(quiz);
		QuizRepository.save(quiz);
	
		
	}

}
