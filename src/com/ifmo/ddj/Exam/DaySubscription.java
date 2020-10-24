package com.ifmo.ddj.Exam;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class DaySubscription extends Membership implements VisitAble {
    final static LocalTime STARTWORKINGHOUR = LocalTime.of(8, 0);
    final static LocalTime ENDWORKINGHOUR = LocalTime.of(16, 0);

    public DaySubscription(LocalDateTime endRegistration, Client client, Fitness fitness) {
        super(endRegistration, client, fitness);
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
                System.out.println(client.getName() + " " + client.getSurname() +
                        ", Ваш абонемент не включает проход в бассейн."
                        + " Выберите тренажерный зал или групповую тренировку");
                break;
        }
    }

    private void visitGym() {
        if (checkAccess(STARTWORKINGHOUR, ENDWORKINGHOUR) && !this.client.isTraining()) {
            this.getFitness().addToGym(this.client);
            this.client.setTraining(true);
            this.whereClient = "Тренажерный зал.";
            Logger.printVisitInfo(this);
        }
    }

    private void visitGroupTraining() {
        if (checkAccess(STARTWORKINGHOUR, ENDWORKINGHOUR) && !this.client.isTraining()) {
            this.getFitness().addToGroupTraining(this.client);
            this.client.setTraining(true);
            this.whereClient = "Групповые тренировки.";
            Logger.printVisitInfo(this);
        }
    }
}
