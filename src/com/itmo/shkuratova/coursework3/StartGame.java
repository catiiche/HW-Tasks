package com.itmo.shkuratova.coursework3;

public class StartGame implements Command {
    private final Game game; // почему final ?

    public StartGame(Game game) {
        this.game = game;
    }



    @Override
    public void execute() {
        game.newGame();

        /*Game game = new Game();
        game.start();*/

    }

    @Override
    public Integer printMenu() {
        return null;
    }
}
