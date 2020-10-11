package com.ifmo.jjd.Lesson8.Homework8School;

public class Teachers extends SchoolParticipants implements TeachAble {
    public Teachers(String name, int age, String schoolSubject) {
        super(name, age, schoolSubject);
    }

    @Override
    public void teach(Pupils pupils) {
        getSchoolSubject();
        pupils.study();
    }
}
