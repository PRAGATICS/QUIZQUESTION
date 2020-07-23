package org.codejudge.sb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {

    private Long questionId;

    private String name;

    private String options;

    private int correct_option;

    private int points;

    private Long quiz;


}
