package com.itmo.shkuratova.coursework3;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SaveGame implements Serializable {
    private final String user;
    private final String gameState;
    private LocalDateTime dateTime;
    private static final long serialVersionID = 1L;

    public SaveGame(String user, String gameState, LocalDateTime date) {
        this.user = user;
        this.gameState = gameState;
        this.dateTime = LocalDateTime.now();
    }

    public String getUser() {
        return user;
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
