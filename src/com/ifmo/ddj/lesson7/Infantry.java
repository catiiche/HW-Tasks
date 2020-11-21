package com.ifmo.ddj.lesson7;

import java.io.File;
import java.io.Serializable;
import java.util.Objects;

public class Infantry extends BattleUnit implements Serializable {

    private static final long serialVersionID = 1L;

    public Infantry(int healthPoints, int agilityPoints, int attackPoints) {
        super(healthPoints, agilityPoints, attackPoints);
    }

    //    реализация метода attack(BattleUnit) интерфейса Attackable
    @Override
    public void attack(BattleUnit unit) {
//     1 если  this жив и ловкость unit меньше this:
//        unit.health -= this.attack
//        2 если unit выжил и его ловкость больше this:
//        this.health -= this.attack

        if (this.isAlive() && unit.isAlive() && unit.agilityPoints <= this.agilityPoints)
            unit.minusHealth(this.attackPoints);
        else if (unit.isAlive() && this.isAlive() && this.agilityPoints >= unit.agilityPoints)
            this.minusHealth(unit.attackPoints);
    }

    @Override
    public void rest() {
        this.plusHealth(2);
    }

    @Override
    public String toString() {
        return "Infantry" +
                "attackPoints=" + attackPoints +
                ", healthPoints=" + healthPoints +
                ", agilityPoints=" + agilityPoints +
                ", maxHealth=" + maxHealth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(healthPoints, agilityPoints, maxHealth);
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
}
