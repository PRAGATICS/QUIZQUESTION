package org.codejudge.sb.repository;

import org.codejudge.sb.domain.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends CrudRepository<Question,Long>{

	public Question findByid(Long QuestionId);

}
