package com.itmo.shkuratova.coursework3;

public class StartNewGameCommand implements Command {
    private final Game game;

    public StartNewGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.newGame();
    }
}

