package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setInitials("K.J.");
        student.setGroup("IKO-104");
        student.setDateOfReceipt(new Date());
        System.out.println("Student's initials: " + student.getInitials()
                + System.lineSeparator() + "Group: " + student.getGroup()
                + System.lineSeparator() + "Date of receipt: " + student.getDateOfReceipt());
    }
}
