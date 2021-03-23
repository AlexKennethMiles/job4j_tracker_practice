package ru.job4j.oop;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthday;
    private String experience;
    private String post;
    private String specialization;

    public Profession(String name, String surname, String education,
                      String birthday, String experience, String post,
                      String specialization) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
        this.experience = experience;
        this.post = post;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getExperience() {
        return experience;
    }

    public String getPost() {
        return post;
    }

    public String getSpecialization() {
        return specialization;
    }
}
