package com.tjh.jdbc.jdbcBase.day06;

import com.tjh.jdbc.jdbcBase.day03.JDBCUtils01;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Create by koala on 2021-01-19
 *
 * 批量插入的方式四：设置连接不允许自动提交数据
 *
 */
public class InsertTest03 {

    @Test
    public void testInsert1() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            long start = System.currentTimeMillis();

            conn = JDBCUtils01.getConnection();

            //设置不允许自动提交数据
            conn.setAutoCommit(false);

            String sql = "insert into goods(name)values(?)";
            ps = conn.prepareStatement(sql);
            for(int i = 1;i <= 1000000;i++){
                ps.setObject(1, "name_" + i);

                //1."攒"sql
                ps.addBatch();

                if(i % 500 == 0){
                    //2.执行batch
                    ps.executeBatch();

                    //3.清空batch
                    ps.clearBatch();
                }

            }

            //提交数据
            conn.commit();

            long end = System.currentTimeMillis();

            System.out.println("花费的时间为：" + (end - start));//20000:83065 -- 565
        } catch (Exception e) {								     //1000000:16086 -- 5114
            e.printStackTrace();
        }finally{
            JDBCUtils01.closeResource(conn, ps);
        }

    }

}
