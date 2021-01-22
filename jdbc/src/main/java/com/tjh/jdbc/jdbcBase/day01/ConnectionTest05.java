package com.tjh.jdbc.jdbcBase.day01;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Create by koala on 2021-01-17
 */
public class ConnectionTest05 {

    // 方式四：可以只是加载驱动，不用显示的注册驱动了
    @Test
    public void testConnection() throws Exception {
        // 1.提供三个连接的基本信息：
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "root";

        // 2.加载Driver
        Class.forName("com.mysql.jdbc.Driver");
        //相较于方式三，可以省略如下的操作：
		/*Driver driver = (Driver) clazz.newInstance();
		DriverManager.registerDriver(driver);*/
        //为什么可以省略上述操作呢？
		/*
		 * 在mysql的Driver实现类中，声明了如下的操作：
		 * static {
		 *		try {
		 *			java.sql.DriverManager.registerDriver(new Driver());
	     *	    } catch (SQLException E) {
		 *			throw new RuntimeException("Can't register driver!");
		 *		}
         *	}
		 */

        // 3.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
    }

}
