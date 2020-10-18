package com.ifmo.ddj.Exam;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class UnlimitedAccess extends Membership implements VisitAble {
    final static LocalTime startWorkingHour = LocalTime.of(8, 0);
    final static LocalTime endWorkingHour = LocalTime.of(22, 0);

    public UnlimitedAccess(LocalDateTime endRegistration, Client client) {
        super(endRegistration, client);
    }

    @Override
    public void visit() {
        random();
        switch (choose) {
            case 0:
                visitGym();
                break;
            case 1:
                visitGroupTraining();
                break;
            case 2:
                visitPool();
                break;
        }
    }

    private void visitPool() {
        if (checkAccess(startWorkingHour, endWorkingHour) && !this.client.isTraining()) {
            Fitness.addToPool(this.client);
            this.client.setTraining(true);
            this.whereClient = "Бассейн";
            System.out.println(client.getName() + " зашел в бассейн.");
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

    private void visitGroupTraining() {
        if (checkAccess(startWorkingHour, endWorkingHour) && !this.client.isTraining()) {
            Fitness.addToGroupTraining(this.client);
            this.client.setTraining(true);
            this.whereClient = "Групповые тренировки.";
            Logger.printVisitInfo(this);
        }
    }
}
