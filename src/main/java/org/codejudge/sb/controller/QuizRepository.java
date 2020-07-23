package org.codejudge.sb.controller;
import java.util.List;

import org.codejudge.sb.domain.Quiz;
import org.springframework.data.repository.CrudRepository;




public interface QuizRepository extends CrudRepository<Quiz,Long>{

	public Quiz findByid(Long quizId);

}
