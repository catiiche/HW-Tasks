package com.itmo.shkuratova.coursework3;

import java.io.*;

public class Game implements Serializable {
    Receiver receiver;
    private Command node;

    public Game() {

        /*В Game сперва создай объект Fox.
Потом добавь его в рессивер.
Потом для объекта фокс вызови сеттер, в который отправишь рессивер

         */


        /*
        this.receiver.addCommand(new Fox());
        this.receiver.addCommand(new Bees());
        this.receiver.addCommand(new DeepForest());
        this.receiver.addCommand(new ForestDwellers());
        this.receiver.addCommand(new GetHoney());
        this.receiver.addCommand(new Home());
        this.receiver.addCommand(new HoneyThief());
        this.receiver.addCommand(new Owl());
        this.receiver.addCommand(new Rest());
        this.receiver.addCommand(new Search());
        this.receiver.addCommand(new Singleton());
        this.receiver.addCommand(new TeddyBear());
        this.receiver.addCommand(new Wolf()); */
    }

    public void start() {
        /*
        в старте, вместо строчки внутри if напиши :
gameNode = new Fox();
После if{} напиши:
recover.addCommand(gameNode):
Затем game.setSeriver(resiver);
         */

        Command gameNode;
        if (this.node == null) {

            gameNode = receiver.getAllCommands().get(0);

        } else gameNode = receiver.getAllCommands().get(receiver.getAllCommands().size() - 1);

        gameNode.execute();
    }
}
