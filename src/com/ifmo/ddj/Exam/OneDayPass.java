package com.ifmo.ddj.Exam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OneDayPass extends Membership implements VisitAble {
    final static LocalTime startWorkingHour = LocalTime.of(8, 0);
    final static LocalTime endWorkingHour = LocalTime.of(22, 0);

    public OneDayPass(Client client) {
        super(client);
        this.startRegistration = LocalDateTime.now();
        this.endRegistration = LocalDateTime.of(LocalDate.now(), LocalTime.of(22, 0));
    }

    @Override
    public void visit() {
        random();
        switch (choose) {
            case 0:
                visitGym();
                break;
            case 1:
                visitPool();
                break;
            case 2:
                System.out.println("Ваш абонемент не включает проход на групповую тренировку." +
                        " Выберете тренажерный зал или бассейн");
                break;
        }
    }

    private void visitPool() {
        if (checkAccess(startWorkingHour, endWorkingHour) && !this.client.isTraining()) {
            Fitness.addToPool(this.client);
            this.client.setTraining(true);
            this.whereClient = "Бассейн.";
            Logger.printVisitInfo(this);
        }
    }

    private void visitGym() {
        if (checkAccess(startWorkingHour, endWorkingHour) && !this.client.isTraining()) {
            Fitness.addToGym(this.client);
            this.client.setTraining(true);
            this.whereClient = "Тренажерный зал.";
            Logger.printVisitInfo(this);
        }
    }
}
