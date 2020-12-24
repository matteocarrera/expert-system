package org.grecha.questionBlocks;

public class WebDevelopmentQuestions extends QuestionBlock {

    public WebDevelopmentQuestions() {
        this.setTitle("Веб-разработка");
        this.setQuestions(new Question[]{
                new Question("Web-страница представляет собой:",
                        "HTML",
                        new String[] {
                                "Текстовый файл с расширением txt или doc",
                                "Текстовый файл с расширением htm или html",
                                "Двоичный файл с расширением com или exe"},
                        2),
                new Question("Почему в PHP файлах не рекомендуется ставить \"?>\" закрывающийся тег?",
                        "PHP",
                        new String[] {
                                "Для того чтобы предотвратить случайное включение пробелов или переносов на новую строку",
                                "Подобная рекомендация улучшает читабельность",
                                "Это важный аспект безопасности"},
                        1),
                new Question("В чём разница между echo и print?",
                        "PHP",
                        new String[] {
                                "Между этими функциями нет никакой разницы",
                                "echo можно использовать как часть выражения, а print нет",
                                "print можно использовать как часть выражения, а echo нет"},
                        3),
                new Question("Гипертекст - это:",
                        "HTML",
                        new String[] {
                                "Текст очень большого размера",
                                "Текст, в котором используется шрифт большого размера",
                                "Структурированный текст, где возможны переходы по выделенным меткам"},
                        3),
                new Question("Какого тега НЕ существует?",
                        "HTML",
                        new String[] {
                                "<adress>",
                                "<em>",
                                "<ol>"},
                        1),
                new Question("Какого типа данных в PHP нет?",
                        "PHP",
                        new String[] {
                                "Указатель",
                                "null",
                                "Объект"},
                        1),
                new Question("Выберите верное утверждение относительно следующего запроса:\n" +
                        "SELECT `name` FROM `users`",
                        "SQL",
                        new String[] {
                                "В запросе ошибка",
                                "Результат будет содержать 1 столбец",
                                "Результат будет содержать 2 столбца"},
                        2),
                new Question("Какой из вариантов объявления функции правильный: var func = function() {}; или function func() {}?",
                        "JavaScript",
                        new String[] {
                                "function func() {}",
                                "var func = function() {};",
                                "Оба варианта правильные."},
                        3)
        });
    }
}
