package com.ifmo.jjd.Lesson8.Homework8School;

public class Principal extends Teachers {
    public Principal(String name, int age, String schoolSubject) {
        super(name, age, schoolSubject);
    }

    public boolean startLearning() {
        return true;
    }

    public boolean endLearning() {
        return false;
    }
}


