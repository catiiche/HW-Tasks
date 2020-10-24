package com.ifmo.ddj.Exam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OneDayPass extends Membership implements VisitAble {
    final static LocalTime STARTWORKINGHOUR = LocalTime.of(8, 0);
    final static LocalTime ENDWORKINGHOUR = LocalTime.of(22, 0);

    public OneDayPass(Client client, Fitness fitness) {
        super(client);
        this.startRegistration = LocalDateTime.now();
        this.endRegistration = LocalDateTime.of(LocalDate.now(), LocalTime.of(22, 0));
        this.fitness = fitness;
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
                System.out.println(client.getName() + " " + client.getSurname() +
                        ", Ваш абонемент не включает проход на групповые тренировки" +
                        ", выберите тренажерный зал или бассейн");
                break;
        }
    }

    private void visitPool() {
        if (checkAccess(STARTWORKINGHOUR, ENDWORKINGHOUR) && !this.client.isTraining()) {
            this.getFitness().addToPool(this.client);
            this.client.setTraining(true);
            this.whereClient = "Бассейн.";
            Logger.printVisitInfo(this);
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
}
