package com.itmo.shkuratova.coursework3;

public class ExitGame implements Command {
    private final Game game;

    public ExitGame(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
   //     game.exit();
    }


}
