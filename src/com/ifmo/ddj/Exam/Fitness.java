package com.ifmo.ddj.Exam;

import java.time.LocalDateTime;
import java.time.Month;

public class Fitness {
    private final static int CNT = 20;
    private static Client[] clientsPool = new Client[CNT];
    private static Client[] clientsGym = new Client[CNT];
    private static Client[] clientsGroupTraining = new Client[CNT];

    public static void main(String[] args) {
        Fitness fitness = new Fitness();

        Client client1 = new Client("Ivan", "Ivanov", 1985);
        Client client2 = new Client("Lisa", "Denizo", 1990);
        Client client3 = new Client("Petr", "Sidorochkin", 1995);

        OneDayPass oneDayPass = new OneDayPass(client1, fitness);

        LocalDateTime endRegistration = LocalDateTime.of(2020, Month.NOVEMBER, 20, 5, 55);
        DaySubscription daySubscription = new DaySubscription(endRegistration, client2, fitness);
        UnlimitedAccess unlimitedAccess = new UnlimitedAccess(endRegistration, client3, fitness);

        // Когда клиент приходит в фитнес клуб, он сообщает желаемую зону и показывает абонемент.
        oneDayPass.visit();
        daySubscription.visit();
        unlimitedAccess.visit();

        Logger.visitors(new Fitness());
    }

    public static Client[] getClientsPool() {
        return clientsPool;
    }

    public static Client[] getClientsGym() {
        return clientsGym;
    }

    public static Client[] getClientsGroupTraining() {
        return clientsGroupTraining;
    }

    public void close() {
        for (int i = 0; i < CNT; i++) {
            clientsPool[i] = null;
            clientsGym[i] = null;
            clientsGroupTraining[i] = null;
        }
    }

    public boolean addToGym(Client client) {
        for (int i = 0; i < clientsGym.length; i++) {
            if (clientsGym[i] == null) {
                clientsGym[i] = client;
                return true;
            }
        }
        int[] unoccupied = checkOccupied();
        System.out.println("Нет свободных мест в тренажерном зале.");
        printRejectionCause();
        return false;
    }

    public boolean addToPool(Client client) {
        for (int i = 0; i < clientsPool.length; i++) {
            if (clientsPool[i] == null) {
                clientsPool[i] = client;
                return true;
            }
        }
        int[] unoccupied = checkOccupied();
        System.out.println("Нет свободных мест в бассейне.");
        printRejectionCause();
        return false;
    }

    public boolean addToGroupTraining(Client client) {
        for (int i = 0; i < clientsGroupTraining.length; i++) {
            if (clientsGroupTraining[i] == null) {
                clientsGroupTraining[i] = client;
                return true;
            }
        }
        int[] unoccupied = checkOccupied();
        System.out.println("Нет свободных мест на групповых тренировках.");
        printRejectionCause();
        return false;
    }

    public int[] checkOccupied() {
        int cntPool = 0;
        int cntGym = 0;
        int cntGroupTraining = 0;

        for (int i = 0; i < CNT; i++) {
            if (clientsPool[i] != null) cntPool++;
            if (clientsGym[i] != null) cntGym++;
            if (clientsGroupTraining[i] != null) cntGroupTraining++;
        }

        // [0] - свободно мест в бассейне
        // [1] - свободно мест в тренажерном зале
        // [2] - свободно мест на групповой тренировке
        int[] unoccupied = {cntPool, cntGym, cntGroupTraining};
        return unoccupied;
    }

    public void printRejectionCause() {
        int[] unoccupied = checkOccupied();
        System.out.println("\nCвободные места в бассейне: "
                + unoccupied[0]
                + "\nCвободные места в тренажерном зале:  "
                + unoccupied[1]
                + "\nCвободные места на групповом занятии: "
                + unoccupied[2]);
    }
}
