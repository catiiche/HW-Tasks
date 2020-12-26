package com.itmo.shkuratova.coursework3;

/**
 * class GameApp
 * use for run program
 *
 * @author Kate Shkuratova
 * @version 1.1
 * @see StartNewGameCommand
 * @see LoadGameCommand
 * @see SaveGameCommand
 * @see ExitGameCommand
 * @see Menu
 * @see Strategy
 * @see Game
 */
public class GameApp {
    public static void main(String[] args) {

        Strategy loadGame = new GameSaver();

        Game game = new Game(loadGame);

        StartNewGameCommand gameStart = new StartNewGameCommand(game);
        LoadGameCommand gameLoad = new LoadGameCommand(game);
        SaveGameCommand gameSave = new SaveGameCommand(game);
        ExitGameCommand gameExit = new ExitGameCommand(game);

        Menu menu = new Menu();

        menu.setCommand(1, gameStart);
        menu.setCommand(2, gameLoad);
        menu.setCommand(3, gameSave);
        menu.setCommand(4, gameExit);

        menu.printMenu();

    }
}
