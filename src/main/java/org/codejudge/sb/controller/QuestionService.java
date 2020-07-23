package org.codejudge.sb.controller;

import java.util.ArrayList;
import java.util.List;

import org.codejudge.sb.domain.Question;
import org.codejudge.sb.domain.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository QuestionRepository;
	
	public Question getQuestion(Long QuestionId) {
		return QuestionRepository.findByid(QuestionId);		
		}
	
	public void addQuestion(Question question) {
		// TODO Auto-generated method stub
		QuestionRepository.save(question);
	
		
	}
	
}
