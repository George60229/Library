package com.example.library;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;

public class UserInfo {
    public static int DAYS=10;
    private int id;
    private String login;
    private String book;
    private Date days;

    @Override
    public String toString() {
        return "UserInfo{" +
                "login='" + login + '\'' +
                ", book=" + book +
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

    public Date getDays() {
        return days;
    }

    public void setDays(Date days) {
        this.days = days;
    }
}