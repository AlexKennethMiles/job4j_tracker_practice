package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String initials;
    private String group;
    private Date dateOfReceipt;

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(Date dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }
}
