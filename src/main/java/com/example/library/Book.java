package com.example.library;

import java.util.Objects;

public class Book {


    private int id;
    private String name;
    private String country;

    private String author;

    private int year;
    private int amount=1;
    private boolean isDeleted=false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +

                "  name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", author='" + author + '\'' +
                ", amount='" + amount + '\'' +
                ", year='" + year + '\'' +
                "}";

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && year == book.year && amount == book.amount && isDeleted == book.isDeleted && Objects.equals(name, book.name) && Objects.equals(country, book.country) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, author, year, amount, isDeleted);
    }

}



