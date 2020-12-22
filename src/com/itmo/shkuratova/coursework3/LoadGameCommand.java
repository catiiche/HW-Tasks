package com.itmo.shkuratova.coursework3;

public class LoadGameCommand implements Command {
    private final Game game;

    public LoadGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.load();

    }
}

