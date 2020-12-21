package com.itmo.shkuratova.coursework3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> menu = new ArrayList<>();

    public Menu() {
        menu.add(new StartGame());
        menu.add(new LoadGame());
        menu.add(new ExitGame());
    }

    public void run() {
        int i = this.printMenu();
        this.menu.get(i).execute(); // запуск класса

    }

    public Integer printMenu() {
        System.out.println("Введите команду:\n"
                + "start для начала новой игры\n"
                + "load для загрузки сохраненной игры\n"
                + "exit для выхода");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                if (reader.readLine().equalsIgnoreCase("start")) {
                    return 0;
                } else if (reader.readLine().equalsIgnoreCase("load")) {
                    return 1;
                } else if (reader.readLine().equalsIgnoreCase("exit")) {
                    return 2;
                } else System.out.println("Неправильный ввод. Введите start, load или exit.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
