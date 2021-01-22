package com.tjh.jdbc.jdbcBase.day01;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Create by koala on 2021-01-17
 *
 * http://localhost:8080/gmall/keyboard.jpg
 * jdbc:mysql://localhost:3306/test
 * jdbc:mysql:协议
 * localhost:ip地址
 * 3306：默认mysql的端口号
 * test:test数据库
 *
 */
public class ConnectionTest02 {

    // 方式一：
    @Test
    public void testConnection() throws SQLException{
        // 获取Driver实现类对象
        Driver driver = new com.mysql.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/test";

        // 将用户名和密码封装在Properties中
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        Connection conn = driver.connect(url,info);

        System.out.println(conn);
    }

}
