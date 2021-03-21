package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже,\n"
                    + "Пешеходы по лужам,\n"
                    + "А вода по асфальту рекой.\n"
                    + "И неясно прохожим,\n"
                    + "В этот день непогожий,\n"
                    + "Почему я веселый такой.");
        } else if (position == 2) {
            System.out.println("Спят усталые игрушки, книжки спят.\n"
                    + "Одеяла и подушки ждут ребят.\n"
                    + "Даже сказка спать ложится,\n"
                    + "Чтобы ночью нам присниться.\n"
                    + "Ты ей пожелай:\n"
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
