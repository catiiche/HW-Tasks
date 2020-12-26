package com.itmo.shkuratova.coursework3;

/**
 * class SaveGameCommand implements Command
 * use for saving game
 *
 * @author Kate Shkuratova
 * @version 1.1
 * @see Command
 */
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
