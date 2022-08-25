package com.example.library;

public class UserInfo {
    private int id;
    private String login;
    private String book;
    private int days;

    @Override
    public String toString() {
        return "UserInfo{" +
                "login='" + login + '\'' +
                ", book=" + book +
                ", days=" + days +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}