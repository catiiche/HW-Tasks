package com.itmo.shkuratova.coursework3;

/**
 * interface ChainNodes
 * use for representing the chain pattern
 * helps  get  state of game, add next nodes and handle request
 *
 * @author Kate Shkuratova
 * @version 1.1
 * @see Step
 * @see Nodes
 */

public interface ChainNodes {
    String getGameState();

    ChainNodes setFirstChoice(ChainNodes node);

    ChainNodes setSecondChoice(ChainNodes node);

    String handleRequest();

}
