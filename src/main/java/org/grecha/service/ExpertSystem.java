package org.grecha.service;

import lombok.RequiredArgsConstructor;
import org.grecha.questionBlocks.*;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class ExpertSystem {
    private final Scanner scanner = new Scanner(System.in);
    private PrintStream ps;
    private final QuestionBlock[] questionBlocks = {
            new SoftwareDevelopmentQuestions(),
            new MobileAppsDevelopmentQuestions(),
            new WebDevelopmentQuestions()
    };

    public void start() {
        initPrintStream();

        showMessage("Добро пожаловать в систему подбора онлайн курсов!");
        showMessage("Пройдите небольшой тест и мы поможем Вам с выбором:\n");

        for (QuestionBlock questionBlock : questionBlocks) {
            runQuestionBlock(questionBlock);
        }

        System.exit(0);
    }

    private void runQuestionBlock(QuestionBlock questionBlock) {
        Integer score = 0;
        showMessage("Заинтересованы ли Вы в разделе \"" + questionBlock.getTitle() + "\"?\n1. Да\n2. Возможно\n3. Нет");
        switch (scanner.nextInt()) {
            case 1:
                questionBlock.setInterestRate(InterestRate.HIGH);
                break;
            case 2:
                questionBlock.setInterestRate(InterestRate.MIDDLE);
                break;
            case 3:
                questionBlock.setInterestRate(InterestRate.LOW);
                break;
            default:
                showMessage("Такого значения нет!");
                break;
        }

        showMessage("\nОтветьте на несколько вопросов по данному разделу:\n");

        for (Question question : questionBlock.getQuestions()) {
            showMessage(question.getTitle());
            for (int i = 0; i < question.getAnswers().length; i++) {
                showMessage((i + 1) + "\t" + question.getAnswers()[i]);
            }
            int answer = scanner.nextInt();
            if (answer == question.getIndexOfRightAnswer() + 1) {
                score += 25;
                showMessage("Баллов за текущий блок вопросов: " + score.toString() + "/100");
            } else {
                showMessage("Вы допустили ошибку!");
            }
            showMessage("");
        }
        questionBlock.setFinalScore(score);
    }

    private void initPrintStream() {
        try {
            ps = new PrintStream(System.out, true, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void showMessage(String text) {
        ps.print(text + "\n");
    }
}
