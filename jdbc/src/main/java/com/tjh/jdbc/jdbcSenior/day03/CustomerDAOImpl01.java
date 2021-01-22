package com.tjh.jdbc.jdbcSenior.day03;

import com.tjh.jdbc.jdbcSenior.day02.Customer02;

import java.sql.Connection;
import java.util.List;

/**
 * Create by koala on 2021-01-20
 */
public class CustomerDAOImpl01 extends BaseDAO01<Customer02> implements CustomerDAO01 {

    @Override
    public Customer02 getCustomerById(Connection conn, int id) {
        String sql = "select id,name,email,birth from customers where id = ?";
        Customer02 customer = getInstance(conn,sql,id);
        return customer;
    }

    @Override
    public List<Customer02> getAll(Connection conn) {
        String sql = "select id,name,email,birth from customers";
        List<Customer02> list = getForList(conn, sql);
        return list;
    }


}
