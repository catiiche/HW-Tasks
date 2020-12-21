package com.itmo.shkuratova.coursework3;

public class GetHoney implements Command {
    @Override
    public void execute() {
        System.out.println("Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. Лисёнок всегда боялся пчёл,\n"
                + "но и не найти друга он тоже боялся.");
    }

    @Override
    public Integer printMenu() {
        return null;
    }
}
