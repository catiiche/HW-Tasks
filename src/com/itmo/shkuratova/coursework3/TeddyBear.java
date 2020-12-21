package com.itmo.shkuratova.coursework3;

public class TeddyBear implements Command {
    @Override
    public void execute() {
        System.out.println("Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок и уверен,\n"
                + "что Бельчонок никогда не пошёл бы в глубь леса. Он заверял Лисёнка, что Белки не попадают\n"
                + "в неприятности, и что Совам нельзя верить, он также уговаривал Лисёнка\n"
                + "вернуться домой.");
    }

    @Override
    public Integer printMenu() {
        return null;
    }
}
