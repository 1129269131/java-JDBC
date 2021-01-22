package com.tjh.jdbc.jdbcSenior.day07;

import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Create by koala on 2021-01-21
 *
 * 使用dbutils.jar中提供的DbUtils工具类，实现资源的关闭
 *
 */
public class dbutilsClose05 {

    public static void closeResource1(Connection conn, Statement ps, ResultSet rs) {
        //方式一：
		/*try {
			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			DbUtils.close(ps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			DbUtils.close(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/

        //方式二：
        DbUtils.closeQuietly(conn);
        DbUtils.closeQuietly(ps);
        DbUtils.closeQuietly(rs);
    }

}
