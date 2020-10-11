package com.ifmo.jjd.Lesson8.Homework8School;

public abstract class SchoolParticipants {
    protected String name;
    protected int age;
    protected String schoolSubject;

    public SchoolParticipants(String name, int age, String schoolSubject) {
        setName(name);
        setAge(age);
        setSchoolSubject(schoolSubject);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.length() < 3)
            throw new IllegalArgumentException("name должен быть не меньше 3");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 5 || age > 80)
            throw new IllegalArgumentException("age должен быть не меньше 5 и не больше 80");
        this.age = age;
    }

    public String getSchoolSubject() {
        return schoolSubject;
    }

    public void setSchoolSubject(String schoolSubject) {
        if(schoolSubject == null || schoolSubject.length() < 3)
            throw new IllegalArgumentException("schoolSubject должен быть не меньше 3");
        this.schoolSubject = schoolSubject;
    }
}
