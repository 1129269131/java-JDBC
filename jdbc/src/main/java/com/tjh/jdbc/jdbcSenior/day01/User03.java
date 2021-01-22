package com.tjh.jdbc.jdbcSenior.day01;

/**
 * Create by koala on 2021-01-20
 */
public class User03 {

    private String user;
    private String password;
    private int balance;

    public User03() {
        super();
    }

    public User03(String user, String password, int balance) {
        super();
        this.user = user;
        this.password = password;
        this.balance = balance;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User03 [user=" + user + ", password=" + password + ", balance=" + balance + "]";
    }

}
