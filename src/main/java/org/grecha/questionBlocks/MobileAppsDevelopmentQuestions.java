package org.grecha.questionBlocks;

public class MobileAppsDevelopmentQuestions extends QuestionBlock {

    public MobileAppsDevelopmentQuestions() {
        this.setTitle("Разработка мобильных приложений");
        this.setQuestions(new Question[]{
                new Question("Набор средств программирования, который содержит инструменты, необходимые для создания, компиляции и сборки мобильного Android приложения называется:",
                        "Kotlin",
                        new String[]{"Android SDK", "Android NDK", "JDK"},
                        1),
                new Question("Ядро какой операционной системы использовалось в качестве базы для ОС Android?",
                        "Kotlin",
                        new String[]{"Windows", "Android OS", "Linux"},
                        3),
                new Question("В среде Intel XDK можно разрабатывать приложения для следующих платформ",
                        "Kotlin",
                        new String[]{"Android", "Apple iOS", "Оба варианта верны"},
                        3),
                new Question("Возможен ли перенос приложений iOS в среду HTML5:",
                        "Swift",
                        new String[]{"Нет, прямой перенос приложений невозможен", "Да, используя средства Intel XDK", "Да, только для iPhone, используя средства Intel XDK"},
                        2),
                new Question("Какое выражение Kotlin эквивалентно данному из Java? int x = a ? b : c",
                        "Kotlin",
                        new String[]{"val x = if (a) b else c", "val x = if (a) b : c", "val x = a ? b : c"},
                        1),
                new Question("Удобное средство обмена между двумя NFC-устройствами:",
                        "Kotlin",
                        new String[]{"Wi-Fi Direct", "AndroidBeam", "Dalvik"},
                        2),
                new Question("Что не является условием компиляции в Swift?",
                        "Swift",
                        new String[]{"#if os", "#if compiler", "#if platform"},
                        3),
                new Question("Какой из датчиков не используется для определения положения смартфона в пространстве?",
                        "Swift",
                        new String[]{"акселерометр", "gps", "магнитометр"},
                        2)
        });
    }
}
