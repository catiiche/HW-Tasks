package com.itmo.shkuratova.coursework3;

/**
 * class StartNewGameCommand implements Command
 * use for starting new game
 *
 * @author Kate Shkuratova
 * @version 1.1
 * @see ExitGameCommand
 * @see Game
 */
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

