package com.itmo.shkuratova.coursework3;

public abstract class Step implements ChainNodes {
    protected final String gameState;
    protected final String text;
    protected ChainNodes firstChoice;
    protected ChainNodes secondChoice;
    public abstract int handleChoice();

    public Step(String state, String text) {
        this.gameState = state;
        this.text = text;
    }


    public String getText() {
        return text;
    }

    @Override
    public String getGameState() {
        return gameState;
    }


    @Override
    public ChainNodes setFirstChoice(ChainNodes node) {
        firstChoice = node;
        return this;
    }

    @Override
    public ChainNodes setSecondChoice(ChainNodes node) {
        secondChoice = node;
        return this;
    }

    @Override
    public String handleRequest() {
        if(firstChoice != null || secondChoice != null) {
            int choice = handleChoice();
            if(choice == 1) return firstChoice.handleRequest();
            if (choice == 2) return secondChoice.handleRequest();
        }
        return gameState;
    }
}
