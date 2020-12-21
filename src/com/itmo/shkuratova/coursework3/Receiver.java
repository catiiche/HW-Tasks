package com.itmo.shkuratova.coursework3;

import java.util.ArrayList;
import java.util.List;

public class Receiver {
//public static final String START = "Начало"
    List<Command> allCommands = new ArrayList<>();

    public List<Command> getAllCommands() {
        return allCommands;
    }

 void addCommand(Command command) {
        allCommands.add(command);
    }

    void runCommand() {
        for (Command command : allCommands) {
            command.execute();
        }
    }
}
