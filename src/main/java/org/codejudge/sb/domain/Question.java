package org.codejudge.sb.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.Builder;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "name cannot be null")
    private String name;
    @NotNull(message = "options cannot be null")
    private String options;
    @NotNull(message = "correct_option cannot be null")
    private int correct_option;
    @NotNull(message = "points cannot be null!")
    private int points;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;


}
