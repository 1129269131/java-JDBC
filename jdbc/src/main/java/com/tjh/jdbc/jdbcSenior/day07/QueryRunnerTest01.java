package com.tjh.jdbc.jdbcSenior.day07;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Create by koala on 2021-01-21
 *
 * commons-dbutils 是 Apache 组织提供的一个开源 JDBC工具类库,封装了针对于数据库的增删改查操作
 *
 * 测试插入
 *
 */
public class QueryRunnerTest01 {

    @Test
    public void testInsert() {
        Connection conn = null;

        try {
            QueryRunner runner = new QueryRunner();
            conn = DruidUtils01.getConnection();
            String sql = "insert into customers(name,email,birth)values(?,?,?)";
            int insertCount = runner.update(conn, sql, "蔡徐坤","caixukun@126.com","1997-09-08");
            System.out.println("添加了" + insertCount + "条记录");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DruidUtils01.closeResource(conn, null);
        }

    }

}
