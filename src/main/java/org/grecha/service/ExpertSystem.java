package org.grecha.service;

import lombok.RequiredArgsConstructor;
import org.grecha.entity.Course;
import org.grecha.entity.Direction;
import org.grecha.entity.Feature;
import org.grecha.questionBlocks.*;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Component
@RequiredArgsConstructor
public class ExpertSystem {
    private final CourseService courseService;
    private final DirectionService directionService;
    private final FeatureService featureService;
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

        // Выполняем блок вопросов по каждому направлению
        for (QuestionBlock questionBlock : questionBlocks) {
            runQuestionBlock(questionBlock);
        }

        // Сортируем блоки вопросов по убыванию заинтересованности
        QuestionBlock[] sortedQuestionBlocks = Arrays.stream(questionBlocks)
                .sorted((o1, o2) -> o2.getInterestRate().compareTo(o1.getInterestRate()))
                .toArray(QuestionBlock[]::new);

        // Каждой фиче задаем сложность в зависимости от ответов на тест
        HashMap<Feature, String> featureAndLevelMap = new HashMap<>();
        for (Map.Entry<String, Double> featureWeight : sortByValue(featureMap).entrySet()) {
            Feature feature = featureService.getFeatureByName(featureWeight.getKey());
            if (featureWeight.getValue() == 0) {
                featureAndLevelMap.put(feature, "Легко");
            } else if (featureWeight.getValue() > 0.1 && featureWeight.getValue() < 2) {
                featureAndLevelMap.put(feature, "Средне");
            } else {
                featureAndLevelMap.put(feature, "Сложно");
            }
            //feature.getCourses().forEach(c -> showMessage(c.getTitle()));
        }
        //featureAndLevelMap.forEach((key, value) -> showMessage(key + ": " + value));
        // Вывод веса для каждой фичи
        //sortByValue(featureMap).forEach((key, value) -> showMessage(key + ": " + value));
        HashSet<Course> finalCourses = new HashSet<>();

        // Для каждого блока вопросов
        for (QuestionBlock sortedQuestionBlock : sortedQuestionBlocks) {
            // Если человек хоть как-то заинтересован в данном направлении
            if (sortedQuestionBlock.getInterestRate() > 0.0) {
                // Для каждой фичи и ее сложности смотрим курсы (в модели Feature есть List<Course>)
                for (Map.Entry<Feature, String> feature : featureAndLevelMap.entrySet()) {
                    if (feature.getKey() != null) {
                        // Из каждой пары фичи и ее сложности достаем курсы и проходим по каждому курсу
                        for (Course course : feature.getKey().getCourses()) {
                            // Если у курса сложность такая, какая у текущей фичи, то добавляем в итоговый список
                            if (course.getLevel().equals(feature.getValue())) {
                                finalCourses.add(course);
                            }
                        }
                    }
                }
            }
        }
        finalCourses.forEach(c -> showMessage(c.getTitle() + "\n" + c.getDescription() + "\n" + "Цена: " +
                c.getPrice() + "\n" + "Длительность (в часах): " + c.getDuration() + "\n" + "Ссылка на курс: " +
                c.getCourseLink() + "\n"));



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
            String featureName = question.getFeatureName();
            Double featureCount;

            if (answer == question.getRightAnswer()) {
                featureCount = featureMap.get(featureName) != null ?
                        featureMap.get(featureName) + block.getInterestRate() : block.getInterestRate();
                score++;
                showMessage("Баллов за текущий блок вопросов: " + score.toString() + "/8");
            } else {
                featureCount = featureMap.get(featureName) != null && featureMap.get(featureName) != 0.0 ?
                        featureMap.get(featureName) : 0.0;
                showMessage("Вы допустили ошибку!");
            }

            featureMap.put(featureName, featureCount);
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

    // Сортировка HashMap по убыванию ЗНАЧЕНИЯ, а не ключа
    public static HashMap<String, Double> sortByValue(HashMap<String, Double> hm)
    {
        List<Map.Entry<String, Double>> list = new LinkedList<>(hm.entrySet());

        list.sort(Map.Entry.comparingByValue());
        //Collections.reverse(list);

        HashMap<String, Double> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}
