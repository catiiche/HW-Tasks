package com.itmo.shkuratova.coursework3;

public class Singleton implements Command {
    ExitGame exit;

    @Override
    public void execute() {
        System.out.println("Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился.\n"
                + "Теперь его самого нужно искать.\n"
                + "Игра завершилась неудачей.");
        exit.execute();
    }

    @Override
    public Integer printMenu() {
        return null;
        // см в книге паттернов null метод
    }
}
