package com.itmo.shkuratova.coursework3;

public class Owl implements Command {
    @Override
    public void execute() {
        System.out.println("Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка,\n"
                + "бежавшего в глубь леса. Все лесные жители знают, что в глубине леса опасно, если Бельчонок там,\n"
                + "ему срочно нужна помощь.");
    }

    @Override
    public Integer printMenu() {
        return null;
    }
}
