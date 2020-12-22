package com.itmo.shkuratova.coursework3;

// pattern chain

public interface ChainNodes {
    String getGameState();

    ChainNodes setFirstChoice(ChainNodes node);

    ChainNodes setSecondChoice(ChainNodes node);

    String handleRequest();

}
