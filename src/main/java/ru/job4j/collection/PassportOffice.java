package ru.job4j.collection;

import java.util.HashMap;

public class PassportOffice {
    private HashMap<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String key) {
        return citizens.get(key);
    }

    @Override
    public String toString() {
        return "PassportOffice{"
                + "citizens=" + citizens
                + '}';
    }

}
