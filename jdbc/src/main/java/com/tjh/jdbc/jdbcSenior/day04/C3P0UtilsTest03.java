package com.tjh.jdbc.jdbcSenior.day04;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Create by koala on 2021-01-20
 */
public class C3P0UtilsTest03 {

    @Test
    public void testGetConnection() throws SQLException {
        Connection conn = C3P0Utils03.getConnection();
        System.out.println(conn);
    }

}
