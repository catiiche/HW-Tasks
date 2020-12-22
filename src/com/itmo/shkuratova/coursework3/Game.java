package com.itmo.shkuratova.coursework3;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

public class Game {
    private final Strategy load;
    private String gameState;

    public Game(Strategy load) {
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
    }

    public void save() {
        load.saveGame(new SaveGame(gameState, LocalDateTime.now()));
    }

    public void exit(){
    System.out.println("Game over");
    System.exit(0);
}
}
