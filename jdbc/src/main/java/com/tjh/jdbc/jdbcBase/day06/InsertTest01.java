package com.tjh.jdbc.jdbcBase.day06;

import com.tjh.jdbc.jdbcBase.day03.JDBCUtils01;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Create by koala on 2021-01-19
 *
 * 使用PreparedStatement实现批量数据的操作
 *
 * update、delete本身就具有批量操作的效果。
 * 此时的批量操作，主要指的是批量插入。使用PreparedStatement如何实现更高效的批量插入？
 *
 * 题目：向goods表中插入20000条数据
 * //创建表
 * CREATE TABLE goods(
 *  id INT PRIMARY KEY AUTO_INCREMENT,
 *  NAME VARCHAR(25)
 * );
 * 方式一：使用Statement
 * Connection conn = JDBCUtils.getConnection();
 * Statement st = conn.createStatement();
 * for(int i = 1;i <= 20000;i++){
 * 		String sql = "insert into goods(name)values('name_" + i + "')";
 * 		st.execute(sql);
 * }
 *
 */
public class InsertTest01 {

    //批量插入的方式二：使用PreparedStatement
    @Test
    public void testInsert1() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            long start = System.currentTimeMillis();

            conn = JDBCUtils01.getConnection();
            String sql = "insert into goods(name)values(?)";
            ps = conn.prepareStatement(sql);
            for(int i = 1;i <= 20000;i++){
                ps.setObject(1, "name_" + i);

                ps.execute();
            }

            long end = System.currentTimeMillis();

            System.out.println("花费的时间为：" + (end - start));//20000:83065
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            JDBCUtils01.closeResource(conn, ps);
        }

    }

}
