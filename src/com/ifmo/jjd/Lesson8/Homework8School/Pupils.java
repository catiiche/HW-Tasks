package com.ifmo.jjd.Lesson8.Homework8School;

public class Pupils extends SchoolParticipants implements StudyAble {
    protected int knowledgeLevel = 0;

    public Pupils(String name, int age, String schoolSubject) {
        super(name, age, schoolSubject);
    }
    @Override
    public void study() {
        getSchoolSubject();
        knowledgeLevel++;
    }
}
