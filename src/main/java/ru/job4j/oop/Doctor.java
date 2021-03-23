package ru.job4j.oop;

public class Doctor extends Profession {
    public Doctor(String name, String surname, String education,
                  String birthday, String experience, String post,
                  String specialization) {
        super(name, surname, education, birthday, experience, post, specialization);
    }

    public String inspection(Patient patient) {
        return "healthy";
    }
}
