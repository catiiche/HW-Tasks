package com.itmo.shkuratova.coursework3;

public class SaveGameCommand implements Command {
    private final Game game;

    public SaveGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.save();
    }
}
