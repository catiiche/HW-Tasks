package com.itmo.shkuratova.coursework3;

import java.time.LocalDateTime;

/**
 * class Game
 * use for new game creation, for loading, saving and for exit game
 *
 * @author Kate Shkuratova
 * @version 1.1
 * @see ChainNodes
 * @see Nodes
 */
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
        if (nodes != null){
            gameState = nodes.handleRequest();
        }
    }

    public void save() {
        load.saveGame(new SaveGame(gameState, LocalDateTime.now()));
    }

    public void exit() {
        System.out.println("Game over");
        System.exit(0);
    }
}
