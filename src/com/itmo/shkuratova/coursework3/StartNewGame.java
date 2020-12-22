package com.itmo.shkuratova.coursework3;

public class StartNewGame implements Command {
    private final Game game;

    public StartNewGame(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.newGame();
    }
}

