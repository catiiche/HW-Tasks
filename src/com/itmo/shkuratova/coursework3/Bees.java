package com.itmo.shkuratova.coursework3;

public class Bees implements Command {
    @Override
    public void execute() {
        System.out.println("Лисёнок подождал немного, и пчёлы разлетелись. Лисёнок без проблем набрал мёда.\n"
                + "Вдруг он понял, что очень голоден.\n"
                + "Что же делать?");
    }

    @Override
    public Integer printMenu() {
        return null;
    }
}
