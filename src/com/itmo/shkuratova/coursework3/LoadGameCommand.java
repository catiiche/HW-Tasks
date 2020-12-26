package com.itmo.shkuratova.coursework3;

/**
 * class LoadGameCommand implements Command
 * use for loading game
 *
 * @author Kate Shkuratova
 * @version 1.1
 * @see Command
 */
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

