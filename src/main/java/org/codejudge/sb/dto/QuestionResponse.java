package org.codejudge.sb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {

    private long id;
    private String name;
    private String options;
    private String correct_option;
    private long quiz;
    private int points;


}
