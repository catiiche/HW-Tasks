package com.ifmo.ddj.lesson20.socketio;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SimpleMessage implements Serializable {
    private String sender;
    private String text;
    private LocalDateTime dateTime;
    private static final long serialVersionID = 1L;

    public SimpleMessage(String sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateTime() {
        dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "sender='" + sender + '\'' +
                ", text='" + text + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    public static SimpleMessage getMessage(String sender, String text) {
        return new SimpleMessage(sender, text);
    }
}
