package com.itmo.shkuratova.coursework3;

/**
 * class ExitGameCommand implements Command
 * use for realization of exit method
 *
 * @author Kate Shkuratova
 * @version 1.1
 * @see Command
 */
public class ExitGameCommand implements Command {
    private final Game game;

    public ExitGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.exit();
    }
}
