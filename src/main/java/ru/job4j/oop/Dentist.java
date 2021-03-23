package ru.job4j.oop;

public class Dentist extends Doctor {
    private String equipment;

    public Dentist(String name, String surname, String education,
                   String birthday, String experience, String post,
                   String specialization, String equipment) {
        super(name, surname, education, birthday, experience, post, specialization);
        this.equipment = equipment;
    }

    public String getEquipment() {
        return equipment;
    }

    public void cureATooth() {
    }
}
