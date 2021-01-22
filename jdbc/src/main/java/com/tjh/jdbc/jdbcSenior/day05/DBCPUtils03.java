package com.tjh.jdbc.jdbcSenior.day05;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Create by koala on 2021-01-21
 *
 * 使用DBCP数据库连接池技术获取数据库连接
 *
 */
public class DBCPUtils03 {

    //创建一个DBCP数据库连接池
    private static DataSource source;

    static {
        try {
            Properties pros = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
            pros.load(is);
            source = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        Connection conn = source.getConnection();

        return conn;
    }

}
