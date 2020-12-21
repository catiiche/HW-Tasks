package com.itmo.shkuratova.coursework3;

public class Search implements Command {
    @Override
    public void execute() {
        System.out.println("Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему.\n"
                + "Но вдруг кто нибудь видел Бельчонка... Лисёнок не знал, что ему делать.\n"
                + "Помогите ему.");
    }

    @Override
    public Integer printMenu() {
        return null;
    }
}
