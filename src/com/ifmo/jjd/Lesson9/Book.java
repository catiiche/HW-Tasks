package com.ifmo.jjd.Lesson9;

import java.util.Objects;

public class Book {
    private String title;
    private int pageCount;
    private Author author;

    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        Objects.requireNonNull(author, "автор не может быть null");
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

}
