package org.grecha.service;

import lombok.RequiredArgsConstructor;
import org.grecha.entity.Area;
import org.grecha.entity.Specialty;
import org.grecha.questionBlocks.*;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class ExpertSystem {
    private final AreaService areaService;
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
        showMessage("Пройдите небольшой тест и мы поможем Вам с выбором:");
        showMessage("");

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

        for (Question question : questionBlock.getQuestions()) {
            showMessage(question.getTitle() + "\n");
            for (int i = 0; i < question.getAnswers().length; i++) {
                showMessage((i + 1) + "\t" + question.getAnswers()[i]);
            }
            int answer = scanner.nextInt();
            if (answer == question.getIndexOfRightAnswer() + 1) {
                score += 25;
                showMessage(score.toString());
            } else {
                showMessage("Вы допустили ошибку!");
            }
        }
        questionBlock.setFinalScore(score);
    }

    private Area getSelectedArea() {
        List<Area> areas = areaService.getAllAreas();

        for (int i = 0; i < areas.size(); i++) {
            showMessage((i + 1) + "\t" + areas.get(i).getName() + "\n");
        }

        showMessage("Введите цифру направления: ");

        int selectedAreaNumber = scanner.nextInt();
        if (selectedAreaNumber - 1 >= areas.size()) {
            showMessage("Ошибка! Такого направления не существует! \n");
            System.exit(0);
        }

        return areas.get(selectedAreaNumber - 1);
    }

    private void showInfoAboutSpecialties(Area selectedArea) {
        showMessage("Выберите специальность по выбранному Вами направлению: \n");

        List<Specialty> selectedAreaSpecialties = selectedArea.getSpecialties();
        for (int i = 0; i < selectedAreaSpecialties.size(); i++) {
            showMessage((i + 1) + "\t" + selectedAreaSpecialties.get(i).getName() + "\n");
        }
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
