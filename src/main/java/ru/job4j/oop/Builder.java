package ru.job4j.oop;

public class Builder extends Engineer {
    private String riskClass;

    public Builder(String name, String surname, String education,
                   String birthday, String experience, String post,
                   String specialization, String riskClass) {
        super(name, surname, education, birthday, experience, post, specialization);
        this.riskClass = riskClass;
    }

    public String getRiskClass() {
        return riskClass;
    }

    public void build() {
    }
}
