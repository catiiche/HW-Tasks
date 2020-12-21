package com.itmo.shkuratova.coursework3;

public class Rest implements Command {
    @Override
    public void execute() {
        System.out.println("Пока Лисёнок ел, злобные пчёлы вернулись и покусали его.\n"
                + "Лисёнку нужна помощь, он не сможет продолжить поиски.\n"
                + "Игра завершилась неудачей.");
    }

    @Override
    public Integer printMenu() {
        return null;
    }
}
