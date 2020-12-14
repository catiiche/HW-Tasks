package com.itmo.shkuratova.coursework2;

import java.io.Serializable;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Objects;

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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        Objects.requireNonNull(user, "user не может быть null");
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        Objects.requireNonNull(text, "text не может быть null");
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "Message{ " +
                "user='" + user + '\'' +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    public static Message getMessage(String user, String text) {
        return new Message(user, text);
    }

    public static Message getMessage(Message message) {
        return new Message(message.getUser(), message.getText());
    }

}


