package org.codejudge.sb.repository;

import org.codejudge.sb.domain.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuizRepository extends CrudRepository<Quiz,Long>{

	public Quiz findByid(Long quizId);

}
