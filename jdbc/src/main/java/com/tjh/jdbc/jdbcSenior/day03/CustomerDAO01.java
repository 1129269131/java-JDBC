package com.tjh.jdbc.jdbcSenior.day03;

import com.tjh.jdbc.jdbcSenior.day02.Customer02;

import java.sql.Connection;
import java.util.List;

/**
 * Create by koala on 2021-01-20
 *
 * 此接口用于规范针对于customers表的常用操作
 *
 */
public interface CustomerDAO01 {

    //针对指定的id查询得到对应的Customer对象
    Customer02 getCustomerById(Connection conn, int id);

    //查询表中的所有记录构成的集合
    List<Customer02> getAll(Connection conn);

}
