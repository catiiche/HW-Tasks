package com.ifmo.ddj.Exam;

import java.time.format.DateTimeFormatter;

public class Logger {
    public static void visitors(Fitness visitors) {
        System.out.println("Посетители тренажерного зала");
        int cnt = 0;
        for (int i = 0; i < Fitness.getClientsGym().length; i++) {
            if (Fitness.getClientsGym()[i] != null) {
                clientInfo(Fitness.getClientsGym()[i]);
                cnt++;
            }
        }
        if (cnt == 0) System.out.println("В тренажерном зале никто не занимается");

        cnt = 0;
        System.out.println("Посетители бассейна");
        for (int i = 0; i < Fitness.getClientsPool().length; i++) {
            if (Fitness.getClientsPool()[i] != null) {
                clientInfo(Fitness.getClientsPool()[i]);
                cnt++;
            }
        }
        if (cnt == 0) System.out.println("В бассейне никто не занимается");

        cnt = 0;
        System.out.println("Посетители групповых тренировок");
        for (int i = 0; i < Fitness.getClientsGroupTraining().length; i++) {
            if (Fitness.getClientsGroupTraining()[i] != null) {
                clientInfo(Fitness.getClientsGroupTraining()[i]);
                cnt++;
            }
        }
        if (cnt == 0) System.out.println("В зале групповых тренировок никто не занимается");
    }

    public static void clientInfo(Client client) {
        System.out.println(client.getName()
                + " "
                + client.getSurname());
    }

    public static void printVisitInfo(Membership membership) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy в HH:mm");
        String visitDate = formatter.format(membership.startRegistration);
        clientInfo(membership.client);
        System.out.println("Зона посещения на данный момент: "
                + membership.whereClient
                + " Дата и время посещения: "
                + visitDate);
    }
}
