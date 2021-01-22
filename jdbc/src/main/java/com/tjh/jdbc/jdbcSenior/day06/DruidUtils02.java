package com.tjh.jdbc.jdbcSenior.day06;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Create by koala on 2021-01-21
 *
 * 使用Druid数据库连接池技术
 *
 */
public class DruidUtils02 {

    private static DataSource source;
    static{
        try {
            Properties pros = new Properties();

            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");

            pros.load(is);

            source = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {

        Connection conn = source.getConnection();
        return conn;
    }

}
