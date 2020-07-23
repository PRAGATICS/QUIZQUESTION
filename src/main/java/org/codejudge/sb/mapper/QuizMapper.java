package org.codejudge.sb.mapper;

import org.codejudge.sb.domain.Question;
import org.codejudge.sb.domain.Quiz;
import org.codejudge.sb.dto.QuestionResponse;
import org.codejudge.sb.dto.QuizQuestionResponse;
import org.codejudge.sb.dto.QuizReponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface QuizMapper {


    QuizReponse mapToDto(Quiz quiz);



}
