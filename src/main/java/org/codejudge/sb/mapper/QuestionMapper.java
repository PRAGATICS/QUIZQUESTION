package org.codejudge.sb.mapper;

import org.codejudge.sb.domain.Question;
import org.codejudge.sb.domain.Quiz;
import org.codejudge.sb.dto.QuestionRequest;
import org.codejudge.sb.dto.QuestionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    @Mapping(target = "name", source = "questionRequest.name")
    @Mapping(target = "id", source = "questionRequest.questionId")
    @Mapping(target = "quiz" , source = "quiz")
    Question map(QuestionRequest questionRequest, Quiz quiz);

    @Mapping(target = "quiz", expression = "java(getQuizId(question.getQuiz()))")
    QuestionResponse mapToDto(Question question);

    default long getQuizId(Quiz quiz) {
        return quiz.getId();
    }


}
