package com.tjh.jdbc.jdbcBase.day02;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Create by koala on 2021-01-17
 */
public class PreparedStatementTest03 {

    //修改customers表的一条记录
    @Test
    public void testUpdate(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils02.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            String sql = "update customers set name = ? where id = ?";
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            ps.setObject(1,"莫扎特");
            ps.setObject(2, 18);
            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //5.资源的关闭
            JDBCUtils02.closeResource(conn, ps);
        }
    }

}
