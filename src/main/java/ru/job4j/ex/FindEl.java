package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("The array does not contain the desired element");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            String[] array = new String[]{"Zero", "One", "Two", "Three"};
            indexOf(array, "Four");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
