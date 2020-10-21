package com.ifmo.ddj.Lesson11.HW;

import java.util.Objects;

public enum Position {
    DIRECTOR(100), CLEANER(50), MANAGER(55);

    private int salary;

    Position(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary <= 0) throw new IllegalArgumentException("salary <= 0");
        this.salary = salary;
    }
}
