package com.tjh.jdbc.jdbcSenior.day02;

import java.sql.Date;

/**
 * Create by koala on 2021-01-20
 */
public class Customer02 {

    private int id;
    private String name;
    private String email;
    private Date birth;

    public Customer02() {
        super();
    }

    public Customer02(int id, String name, String email, Date birth) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customer02 [id=" + id + ", name=" + name + ", email=" + email + ", birth=" + birth + "]";
    }

}
