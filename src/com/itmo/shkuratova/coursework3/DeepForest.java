package com.itmo.shkuratova.coursework3;

public class DeepForest implements Command {
    @Override
    public void execute() {
        System.out.println("В глубине леса Лисёнок встретил Медвежонка.\n"
                + "Ленивый Медвежонок был готов рассказать все, что знает,\n"
                + "если Лисёнок принесёт ему мёда.");
    }

    @Override
    public Integer printMenu() {
        return null;
    }
}
