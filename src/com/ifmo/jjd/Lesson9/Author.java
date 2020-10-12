package com.ifmo.jjd.Lesson9;

import java.util.Objects;

public class Author {
    private String name;
    private String surname;

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o; //приведение типов
        return Objects.equals(name, author.name) &&
                Objects.equals(surname, author.surname);
    //первое текущего объекта, второе - который пришел в о
    }

//    у строк метод equals уже переопределен и работает так как надо

    @Override
    public int hashCode() { // адрес объекта в памяти может меняться. хэшкод не меняется, возвращает int
        return Objects.hash(name, surname);
        }
    }


