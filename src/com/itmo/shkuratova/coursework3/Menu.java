package com.itmo.shkuratova.coursework3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * class Menu
 * use for representing the game menu
 * user could choose option from menu item:
 * create new game
 * load game
 * save game
 * exit
 *
 * @author Kate Shkuratova
 * @version 1.1
 */
public class Menu {
    private final Map<Integer, Command> commandContainer;
    private static final int MENU_CHOICE = 5;
    private static final String MENU =
            "What do you want to do ?\n"
                    + "Press 1 for new game.\n"
                    + "Press 2 to load game\n"
                    + "Press 3 if you want save your game\n"
                    + "Press 4 to exit\n";

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
                int fromClient;
                try {
                    fromClient = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e) {
                    fromClient = -1;
                }
                if (fromClient >= 1 && fromClient < MENU_CHOICE) {
                    getCommand(fromClient).execute();
                    System.out.println(MENU);
                } else System.out.println("Wrong input. Try again!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
