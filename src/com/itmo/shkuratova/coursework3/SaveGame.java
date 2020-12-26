package com.itmo.shkuratova.coursework3;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * class SaveGame implements Serializable
 *
 * helps to save game state and date of saving game
 *
 * @author Kate Shkuratova
 * @version 1.1
 */
public class SaveGame implements Serializable {
    private final String gameState;
    private LocalDateTime dateTime;
    private static final long serialVersionID = 1L;

    public SaveGame(String gameState, LocalDateTime date) {
        this.gameState = gameState;
        this.dateTime = LocalDateTime.now();
    }

    public String getGameState() {
        return gameState;
    }

    public String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yy  HH:mm");
        String dateTimeToStr = formatter.format(dateTime);
        return dateTimeToStr;
    }
}
