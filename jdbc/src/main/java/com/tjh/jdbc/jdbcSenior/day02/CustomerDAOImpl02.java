package com.tjh.jdbc.jdbcSenior.day02;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * Create by koala on 2021-01-20
 */
public class CustomerDAOImpl02 extends BaseDAO01 implements CustomerDAO02{

    @Override
    public void insert(Connection conn, Customer02 cust) {
        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        update(conn, sql,cust.getName(),cust.getEmail(),cust.getBirth());
    }

    @Override
    public void deleteById(Connection conn, int id) {
        String sql = "delete from customers where id = ?";
        update(conn, sql, id);
    }

    @Override
    public void update(Connection conn, Customer02 cust) {
        String sql = "update customers set name = ?,email = ?,birth = ? where id = ?";
        update(conn, sql,cust.getName(),cust.getEmail(),cust.getBirth(),cust.getId());
    }

    @Override
    public Customer02 getCustomerById(Connection conn, int id) {
        String sql = "select id,name,email,birth from customers where id = ?";
        Customer02 customer = getInstance(conn,Customer02.class, sql,id);
        return customer;
    }

    @Override
    public List<Customer02> getAll(Connection conn) {
        String sql = "select id,name,email,birth from customers";
        List<Customer02> list = getForList(conn, Customer02.class, sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from customers";
        return getValue(conn, sql);
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql = "select max(birth) from customers";
        return getValue(conn, sql);
    }

}
