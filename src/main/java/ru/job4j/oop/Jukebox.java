package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже," + System.lineSeparator()
                    + "Пешеходы по лужам," + System.lineSeparator()
                    + "А вода по асфальту рекой." + System.lineSeparator()
                    + "И неясно прохожим," + System.lineSeparator()
                    + "В этот день непогожий," + System.lineSeparator()
                    + "Почему я веселый такой.");
        } else if (position == 2) {
            System.out.println("Спят усталые игрушки, книжки спят." + System.lineSeparator()
                    + "Одеяла и подушки ждут ребят." + System.lineSeparator()
                    + "Даже сказка спать ложится," + System.lineSeparator()
                    + "Чтобы ночью нам присниться." + System.lineSeparator()
                    + "Ты ей пожелай:" + System.lineSeparator()
                    + "Баю-бай.");
        } else {
            System.out.println("Песня не найдена");
        }
        System.out.println("===");
    }

    public static void main(String[] args) {
        Jukebox simple = new Jukebox();
        simple.music(1);
        simple.music(2);
        simple.music(3);
        simple.music(0);
    }
}
