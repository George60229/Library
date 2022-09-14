package com.example.library;

public class Penalty {
    private String login;
    private boolean payed=false;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    @Override
    public String toString() {
        return "Penalty{" +
                "login='" + login + '\'' +
                ", payed=" + payed +
                '}';
    }

}
