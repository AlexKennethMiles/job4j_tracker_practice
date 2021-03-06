package ru.job4j.oop;

public class Builder extends Engineer {
    private String riskClass;

    public Builder(String name, String surname, String education,
                   String birthday, String riskClass) {
        super(name, surname, education, birthday);
        this.riskClass = riskClass;
    }

    public String getRiskClass() {
        return riskClass;
    }

    public void build() {
    }
}
