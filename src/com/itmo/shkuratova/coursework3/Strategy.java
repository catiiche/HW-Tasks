package com.itmo.shkuratova.coursework3;

/**
 * interface ChainNodes
 * use for representing the strategy pattern
 * contains methods that help save game and to load saved game state from file
 *
 * @author Kate Shkuratova
 * @version 1.1
 * @see GameSaver
 */

public interface Strategy {
    String getSaveState();

    void saveGame(SaveGame game);
}
