package org.grecha.questionBlocks;

public class MobileAppsDevelopmentQuestions extends QuestionBlock {

    public MobileAppsDevelopmentQuestions() {
        this.setTitle("Разработка мобильных приложений");
        this.setQuestions(new Question[]{
                new Question("Набор средств программирования, который содержит инструменты, необходимые для создания, компиляции и сборки мобильного Android приложения называется:", new String[]{
                        "1.  Android SDK",
                        "2. Android NDK",
                        "3. JDK"},
                        0),
                new Question("Ядро какой операционной системы использовалось в качестве базы для ОС Android?", new String[]{
                        "1. Windows",
                        "2. Android OS",
                        "3. Linux"},
                        2),
                new Question("В среде Intel XDK можно разрабатывать приложения для следующих платформ", new String[]{
                        "1. Android",
                        "2. Apple iOS",
                        "3. Оба варианта верны"},
                        2),
                new Question("Возможен ли перенос приложений iOS в среду HTML5:", new String[]{
                        "1. Нет, прямой перенос приложений невозможен",
                        "2. Да, используя средства Intel XDK",
                        "3. Да, только для iPhone, используя средства Intel XDK"},
                        1)
        });
    }
}
