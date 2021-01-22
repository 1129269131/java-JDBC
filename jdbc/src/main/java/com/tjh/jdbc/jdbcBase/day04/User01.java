package com.tjh.jdbc.jdbcBase.day04;

/**
 * Create by koala on 2021-01-18
 */
public class User01 {

    private String user;
    private String password;

    public User01() {
    }

    public User01(String user, String password) {
        super();
        this.user = user;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [user=" + user + ", password=" + password + "]";
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

}
