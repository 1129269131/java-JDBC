package com.tjh.jdbc.jdbcSenior.day07;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

/**
 * Create by koala on 2021-01-21
 *
 * 查询特殊值
 *
 */
public class QueryRunnerTest03 {

    //ScalarHandler:用于查询特殊值
    @Test
    public void testQuery1(){
        Connection conn = null;

        try {
            QueryRunner runner = new QueryRunner();
            conn = DruidUtils01.getConnection();

            String sql = "select count(*) from customers";

            ScalarHandler handler = new ScalarHandler();

            Long count = (Long) runner.query(conn, sql, handler);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DruidUtils01.closeResource(conn, null);
        }

    }

    @Test
    public void testQuery2(){
        Connection conn = null;

        try {
            QueryRunner runner = new QueryRunner();
            conn = DruidUtils01.getConnection();

            String sql = "select max(birth) from customers";

            ScalarHandler handler = new ScalarHandler();
            Date maxBirth = (Date) runner.query(conn, sql, handler);
            System.out.println(maxBirth);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DruidUtils01.closeResource(conn, null);
        }

    }

}
