package org.codejudge.sb.controller;

import java.util.List;

import org.codejudge.sb.domain.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question,Long>{

	public Question findByid(Long QuestionId);

}
