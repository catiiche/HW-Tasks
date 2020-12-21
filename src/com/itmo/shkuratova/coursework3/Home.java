package com.itmo.shkuratova.coursework3;

public class Home implements Command {
    @Override
    public void execute() {
        System.out.println("Вернувшись домой, Лисёнок нашёл там Бельчонка.\n"
                + "Оказалось, что Бельчонок пришёл на место встречи раньше и увидел там рой злобных пчел.\n"
                + "Он поспешил предупредить об этом Лисёнка, но они разминулись. Наконец-то друзья нашли друг друга!\n"
                + "Игра завершилась успехом.");
    }

    @Override
    public Integer printMenu() {
        return null;
    }
}
