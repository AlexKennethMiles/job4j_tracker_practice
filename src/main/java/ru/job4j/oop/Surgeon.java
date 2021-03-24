package ru.job4j.oop;

public class Surgeon extends Doctor {
    private int assistants;

    public Surgeon(String name, String surname, String education,
                   String birthday, int assistants) {
        super(name, surname, education, birthday);
        this.assistants = assistants;
    }

    public int getAssistants() {
        return assistants;
    }

    public void emergencyCare(Patient patient) {
    }
}
