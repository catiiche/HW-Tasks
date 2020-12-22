package com.itmo.shkuratova.coursework3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StepChoice extends Step {


    public StepChoice(String state, String text) {
        super(state, text);
    }

    @Override
    public int handleChoice() {
        System.out.println("МОЙ ПУСЯ САМЫЙ КРАСИВЫЙ");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("\n" + getText());

            System.out.println("Press 1 if your choice: " + firstChoice.getGameState()
                    + "\nPress 2 if your choice: " + secondChoice.getGameState()
                    + "\nPress 3 if you prefer back to the menu ");

            int choiceNumber = Integer.parseInt(reader.readLine());
            if(choiceNumber == 1 || choiceNumber == 2) return choiceNumber;
            return 3;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 3;
    }
}
