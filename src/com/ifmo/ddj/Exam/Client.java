package com.ifmo.ddj.Exam;

import java.util.Objects;

public class Client {
    private String name;
    private String surname;
    private int birthdayYear;
    private boolean training;

    public Client(String name, String surname, int birthdayYear) {
        setName(name);
        setSurname(surname);
        setBirthdayYear(birthdayYear);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        Objects.requireNonNull(name, "name не может быть null");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    private void setSurname(String surname) {
        Objects.requireNonNull(surname, "surname не может быть null");
        this.surname = surname;
    }

    public void setTraining(boolean training) {
        this.training = training;
    }

    public int getBirthdayYear() {
        return birthdayYear;
    }

    private void setBirthdayYear(int birthdayYear) {
        if (birthdayYear <= 1900)
            throw new IllegalArgumentException("birthdayYear не может быть меньше либо равным 1900");
        this.birthdayYear = birthdayYear;
    }

    public boolean isTraining() {
        if (training) System.out.println("Вы уже тренируетесь. Вернитесь, пожалуйста, в тренировочную зону.");
        return training;
    }
}
