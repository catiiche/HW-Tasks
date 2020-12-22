package com.itmo.shkuratova.coursework3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameApp {
    public static void main(String[] args) {





        Strategy loadGame = new GameSaver();

        Game game = new Game(getUserName(), loadGame);

        StartNewGameCommand gameStart = new StartNewGameCommand(game);
        LoadGameCommand gameLoad = new LoadGameCommand(game);
        SaveGameCommand gameSave = new SaveGameCommand(game);
        ExitGameCommand gameExit = new ExitGameCommand(game);

        Menu menu = new Menu();

        menu.setCommand(1, gameStart);
        menu.setCommand(2, gameLoad);
        menu.setCommand(3, gameSave);
        menu.setCommand(4, gameExit);

        menu.printMenu();


    }

    private static String getUserName() {
        System.out.println("Type your name.");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String userName = null;
        try {
            userName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userName;
    }
}
