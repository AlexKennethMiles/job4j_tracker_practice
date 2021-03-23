package ru.job4j.oop;

public class Programmer extends Engineer {
    private String programmingLanguage;

    public Programmer(String name, String surname, String education,
                      String birthday, String experience, String post,
                      String specialization, String programmingLanguage) {
        super(name, surname, education, birthday, experience, post, specialization);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void programming() {
    }
}
