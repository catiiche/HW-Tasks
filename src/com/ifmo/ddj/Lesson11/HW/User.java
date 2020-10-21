package com.ifmo.ddj.Lesson11.HW;

import java.util.Objects;

public class User {
    private String fullName;
    private int salary;
    private Position position;

    public User(String fullName, Position position) {
        setFullName(fullName);
        setPosition(position);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        Objects.requireNonNull(fullName, "fullName не должен быть null");
        this.fullName = fullName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
