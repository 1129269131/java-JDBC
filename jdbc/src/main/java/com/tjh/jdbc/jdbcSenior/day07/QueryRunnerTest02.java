package com.tjh.jdbc.jdbcSenior.day07;

import com.tjh.jdbc.jdbcSenior.day02.Customer02;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Create by koala on 2021-01-21
 *
 * 测试查询
 *
 */
public class QueryRunnerTest02 {

    // BeanHandler:是ResultSetHandler接口的实现类，用于封装表中的一条记录。
    @Test
    public void testQuery1(){
        Connection conn = null;

        try {
            QueryRunner runner = new QueryRunner();
            conn = DruidUtils01.getConnection();
            String sql = "select id,name,email,birth from customers where id = ?";
            BeanHandler<Customer02> handler = new BeanHandler<>(Customer02.class);
            Customer02 customer = runner.query(conn, sql, handler, 1);
            System.out.println(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DruidUtils01.closeResource(conn, null);
        }

    }

    // BeanListHandler:是ResultSetHandler接口的实现类，用于封装表中的多条记录构成的集合。
    @Test
    public void testQuery2() {
        Connection conn = null;

        try {
            QueryRunner runner = new QueryRunner();
            conn = DruidUtils01.getConnection();
            String sql = "select id,name,email,birth from customers where id < ?";

            BeanListHandler<Customer02> handler = new BeanListHandler<>(Customer02.class);

            List<Customer02> list = runner.query(conn, sql, handler, 20);
            list.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DruidUtils01.closeResource(conn, null);
        }

    }

}
