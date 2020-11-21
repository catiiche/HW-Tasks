package com.ifmo.ddj.lesson7;

//класс Unit имплементирует интерфейс RestAble, соответственно обязан реализовать
// все методы либо класс должен быть abstract
// Serializable - интерфейс-маркер

// abstract классы могут содержать методы без реализации
// abstract классы могут содержать методы с реализацией
//на основе абстрактного класса нельзя создать объект (new Unit)

import java.io.Serializable;
import java.util.Objects;

abstract public class Unit implements RestAble, Serializable {
    protected int healthPoints;
    protected int agilityPoints;
    protected final int maxHealth;
    private static final long serialVersionID = 1L;

    public Unit(int healthPoints, int agilityPoints) {
        if (healthPoints < 0 || agilityPoints < 0)
            throw new IllegalArgumentException("healthPoints < 0 || agilityPoints < 0");

        maxHealth = healthPoints; //this.maxHealth = healthPoints;
        this.healthPoints = healthPoints;
        this.agilityPoints = agilityPoints;

    }

    public void plusHealth(int points) {
        if (isAlive()) {
            healthPoints += points;
            if (healthPoints > maxHealth)
                healthPoints = maxHealth;
        }
    }

    public void minusHealth(int points) {
        if (isAlive()) {
            healthPoints -= points;
            if (!isAlive()) healthPoints = 0;
        }
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return healthPoints == unit.healthPoints &&
                agilityPoints == unit.agilityPoints &&
                maxHealth == unit.maxHealth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(healthPoints, agilityPoints, maxHealth);
    }
}
