package com.itmo.shkuratova.coursework2;

import java.io.Serializable;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * class Message
 * This class helps to create messages for sending
 *
 * @author Kate Shkuratova
 * @version 1.1
 * @see Client
 * @see MultiThreadServer
 */

public class Message implements Serializable {
    private String user;
    private String text;
    private LocalDateTime dateTime;
    transient private Socket socket;

    public Message(String user, String text) {
        setUser(user);
        setText(text);
        this.dateTime = LocalDateTime.now();
    }

    public void setUser(String user) {
        Objects.requireNonNull(user, "user не может быть null");
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setText(String text) {
        Objects.requireNonNull(text, "text не может быть null");
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy в HH:mm");
        String dateTimeToStr = formatter.format(dateTime);
        return dateTimeToStr;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public Message getMessage(String user, String text) {
        return new Message(user, text);
    }

    @Override
    public String toString() {
        return "Message{" +
                "user = '" + user + '\'' +
                ", text = '" + text + '\'' +
                " " + getDateTime() +
                '}';
    }
}


