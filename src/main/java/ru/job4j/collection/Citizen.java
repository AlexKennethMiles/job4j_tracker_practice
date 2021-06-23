package ru.job4j.collection;

import java.util.Objects;

public class Citizen {
    private String passport;
    private String username;

    public Citizen(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Citizen citizen = (Citizen) obj;
        return Objects.equals(passport, citizen.getPassport())
                && Objects.equals(username, citizen.getUsername());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Citizen{"
                + "passport='" + passport + '\''
                + ", username='" + username + '\''
                + '}';
    }
}
