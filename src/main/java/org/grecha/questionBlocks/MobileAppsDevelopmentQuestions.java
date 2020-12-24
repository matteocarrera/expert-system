package org.grecha.questionBlocks;

public class MobileAppsDevelopmentQuestions extends QuestionBlock {

    public MobileAppsDevelopmentQuestions() {
        this.setTitle("Разработка мобильных приложений");
        this.setQuestions(new Question[]{
                new Question("Набор средств программирования, который содержит инструменты, необходимые для создания, компиляции и сборки мобильного Android приложения называется:", new String[]{
                        "Android SDK",
                        "Android NDK",
                        "JDK"},
                        0),
                new Question("Ядро какой операционной системы использовалось в качестве базы для ОС Android?", new String[]{
                        "Windows",
                        "Android OS",
                        "Linux"},
                        2),
                new Question("В среде Intel XDK можно разрабатывать приложения для следующих платформ", new String[]{
                        "Android",
                        "Apple iOS",
                        "Оба варианта верны"},
                        2),
                new Question("Возможен ли перенос приложений iOS в среду HTML5:", new String[]{
                        "Нет, прямой перенос приложений невозможен",
                        "Да, используя средства Intel XDK",
                        "Да, только для iPhone, используя средства Intel XDK"},
                        1)
        });
    }
}
