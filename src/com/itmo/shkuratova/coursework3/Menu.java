package com.itmo.shkuratova.coursework3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final Map<Integer, Command> commandContainer;
    private static final int MENU_CHOICE = 5;
    private static final String MENU =
            "What do you want to do ?\n"
                    + "Press 1 for new game.\n"
                    + "Press 2 to load game\n"
                    + "Press 3 if you want save your game\n"
                    + "Press 4 to exit";


    public Menu() {
        commandContainer = new HashMap<>();
    }

    public void setCommand(int choice, Command command) {
        commandContainer.put(choice, command);

    }

    public Command getCommand(int choice) {
        return commandContainer.get(choice);
    }

    public void printMenu() {
        System.out.println(MENU);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                int fromClient = Integer.parseInt(reader.readLine());

               // if (fromClient == MENU_CHOICE) break;
                if (fromClient >= 1 && fromClient < MENU_CHOICE) {
                    getCommand(fromClient).execute();
                    System.out.println(MENU);
                } else System.out.println("Wrong number. Try again!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
