package com.itmo.shkuratova.coursework3;

/**
 * interface ChainNodes
 * use for representing the command pattern
 * contains method to execute actions: start new game, save, load and exit game
 *
 * @author Kate Shkuratova
 * @version 1.1
 * @see ExitGameCommand
 * @see LoadGameCommand
 * @see SaveGameCommand
 * @see StartNewGameCommand
 */
public interface Command {
    void execute();
}
