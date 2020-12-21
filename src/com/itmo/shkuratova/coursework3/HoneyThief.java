package com.itmo.shkuratova.coursework3;

public class HoneyThief implements Command {
    @Override
    public void execute() {
        System.out.println("Это была не лучшая идея. Пчёлы покусали Лисёнка, теперь ему самому нужна помощь.\n"
                + "Игра закончилась неудачей.");
    }

    @Override
    public Integer printMenu() {
        return null;
    }
}
