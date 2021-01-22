package com.tjh.jdbc.jdbcBase.day01;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * Create by koala on 2021-01-17
 */
public class ConnectionTest04 {

    // 方式三：使用DriverManager替换Driver
    @Test
    public void testConnection() throws Exception {
        // 1.获取Driver实现类的对象
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 2.提供另外三个连接的基本信息：
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        // 3.注册驱动
        DriverManager.registerDriver(driver);

        // 4.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

}
