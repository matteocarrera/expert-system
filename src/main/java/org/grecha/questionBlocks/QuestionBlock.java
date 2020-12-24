package org.grecha.questionBlocks;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class QuestionBlock {
    private String title;
    private Double interestRate;
    private Question[] questions;
    private Integer finalScore;
}
