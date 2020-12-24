package org.grecha.questionBlocks;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Question {
    private final String title;
    private final String[] answers;
    private final int rightAnswer;
}
