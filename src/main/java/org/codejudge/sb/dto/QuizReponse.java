package org.codejudge.sb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codejudge.sb.domain.Question;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizReponse {

    private long id;
    private String name;
    private String description;

}
