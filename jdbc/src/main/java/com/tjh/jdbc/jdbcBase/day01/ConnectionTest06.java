package com.tjh.jdbc.jdbcBase.day01;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Create by koala on 2021-01-17
 *
 * 此种方式的好处？
 * 1.实现了数据与代码的分离。实现了解耦
 * 2.如果需要修改配置文件信息，可以避免程序重新打包
 *
 */
public class ConnectionTest06 {

    //方式五(final版)：将数据库连接需要的4个基本信息声明在配置文件中，通过读取配置文件的方式，获取连接
    @Test
    public void getConnection() throws Exception{
        //1.读取配置文件中的4个基本信息
        InputStream is = ConnectionTest06.class.getClassLoader().getResourceAsStream("application.properties");

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");

        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

}
