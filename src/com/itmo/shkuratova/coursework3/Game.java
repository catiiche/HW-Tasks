package com.itmo.shkuratova.coursework3;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

public class Game {
    private final String user;
    private final Strategy load;
    private String gameState;

    public Game(String user, Strategy load) {
        this.user = user;
        this.load = load;
        gameState = null;
    }

    public void newGame() {
        gameState = Nodes.START;
        ChainNodes nodes = Nodes.createNodes(gameState);
        if (nodes != null) {
            gameState = nodes.handleRequest();
        }

    }

    public void load() {
            gameState = load.getSaveState();

            ChainNodes nodes = Nodes.createNodes(gameState);
            if (nodes != null) gameState = nodes.handleRequest();


        /*
        System.out.println("--- All save data ---");
        List<SaveGame> saves = load.getSaveList(user);
        for (int i = 0; i < saves.size(); i++)
            System.out.println(i + ". Name: " + saves.get(i).getUser() + ", date " + saves.get(i).getDateTime());

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.println("Press your save number. Press negative number for exit");
                int saveNumber = Integer.parseInt(reader.readLine());
                if (saveNumber < saves.size() && saveNumber >= 0) {
                    gameState = saves.get(saveNumber).getGameState();
                    System.out.println(saves.get(saveNumber).getUser() + "is loaded");

                    ChainNodes nodes = Nodes.createNodes(gameState);
                    if (nodes != null) gameState = nodes.handleRequest();

                    break;
                } else if (saveNumber < 0)
                    break;
                else System.out.println("Incorrect number. Try again!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } */
    }

    public void save() {
        load.saveGame(new SaveGame(user, gameState, LocalDateTime.now()));
    }
}
