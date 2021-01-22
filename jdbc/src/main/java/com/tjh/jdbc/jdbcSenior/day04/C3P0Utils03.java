package com.tjh.jdbc.jdbcSenior.day04;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Create by koala on 2021-01-20
 *
 * 使用C3P0的数据库连接池技术
 *
 */
public class C3P0Utils03 {

    //数据库连接池只需提供一个即可。
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("hellc3p0");

    public static Connection getConnection() throws SQLException {
        Connection conn = cpds.getConnection();

        return conn;
    }

}
