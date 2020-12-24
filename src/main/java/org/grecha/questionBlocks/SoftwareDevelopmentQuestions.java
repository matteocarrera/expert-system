package org.grecha.questionBlocks;

public class SoftwareDevelopmentQuestions extends QuestionBlock {

    public SoftwareDevelopmentQuestions() {
        this.setTitle("Разработка ПО");
        this.setQuestions(new Question[]{
                new Question("1", new String[]{"A", "B", "C"}, 0),
                new Question("2", new String[]{"D", "E", "F"}, 0),
                new Question("3", new String[]{"G", "H", "I"}, 0),
                new Question("4", new String[]{"J", "K", "L"}, 0)
        });
    }
}
