package com.tjh.jdbc.jdbcSenior.day06;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Create by koala on 2021-01-21
 */
public class DruidUtilsTest02 {

    @Test
    public void testGetConnection() throws SQLException {
        Connection conn = DruidUtils02.getConnection();
        System.out.println(conn);
    }

}
