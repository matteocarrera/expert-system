package org.grecha.service;

import lombok.RequiredArgsConstructor;
import org.grecha.questionBlocks.*;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

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
    private final HashMap<String, Double> featureMap = new HashMap<>();

    public void start() {
        initPrintStream();

        showMessage("Добро пожаловать в систему подбора онлайн курсов!");
        showMessage("Пройдите небольшой тест и мы поможем Вам с выбором:\n");

        for (QuestionBlock questionBlock : questionBlocks) {
            runQuestionBlock(questionBlock);
        }

        sortByValue(featureMap).forEach((key, value) -> showMessage(key + ": " + value));

        showMessage("");
        System.exit(0);
    }

    private void runQuestionBlock(QuestionBlock questionBlock) {
        showMessage("Заинтересованы ли Вы в разделе \"" + questionBlock.getTitle() + "\"?\n1. Да\n2. Возможно\n3. Нет");
        switch (scanner.nextInt()) {
            case 1:
                questionBlock.setInterestRate(1.0);
                showQuestionsFromBlock(questionBlock);
                break;
            case 2:
                questionBlock.setInterestRate(0.6);
                showQuestionsFromBlock(questionBlock);
                break;
            case 3:
                questionBlock.setInterestRate(0.0);
                showMessage("Мы не будем задавать Вам вопросы по данному разделу.\n");
                break;
            default:
                showMessage("Такого значения нет!");
                break;
        }
    }

    private void showQuestionsFromBlock(QuestionBlock block) {
        Integer score = 0;
        showMessage("\nОтветьте на несколько вопросов по данному разделу:\n");

        for (Question question : block.getQuestions()) {
            showMessage(question.getTitle());
            for (int i = 0; i < question.getAnswers().length; i++) {
                showMessage((i + 1) + "\t" + question.getAnswers()[i]);
            }
            int answer = scanner.nextInt();
            if (answer == question.getRightAnswer()) {
                String featureName = question.getFeatureName();
                Double featureCount = featureMap.get(featureName) != null ?
                        featureMap.get(featureName) + block.getInterestRate() : block.getInterestRate();
                featureMap.put(featureName, featureCount);
                score++;
                showMessage("Баллов за текущий блок вопросов: " + score.toString() + "/8");
            } else {
                showMessage("Вы допустили ошибку!");
            }
            showMessage("");
        }
        block.setFinalScore(score);
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

    public static HashMap<String, Double> sortByValue(HashMap<String, Double> hm)
    {
        List<Map.Entry<String, Double>> list = new LinkedList<>(hm.entrySet());

        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        HashMap<String, Double> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
