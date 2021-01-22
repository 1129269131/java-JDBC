package com.tjh.jdbc.jdbcBase.day01;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

/**
 * Create by koala on 2021-01-17
 */
public class ConnectionTest03 {

    // 方式二：对方式一的迭代:在如下的程序中不出现第三方的api,使得程序具有更好的可移植性
    @Test
    public void testConnection() throws Exception{
        // 1.获取Driver实现类对象：使用反射
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        // 2.提供要连接的数据库
        String url = "jdbc:mysql://localhost:3306/test";

        // 3.提供连接需要的用户名和密码
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");

        // 4.获取连接
        Connection conn = driver.connect(url, info);
        System.out.println(conn);
    }

}
