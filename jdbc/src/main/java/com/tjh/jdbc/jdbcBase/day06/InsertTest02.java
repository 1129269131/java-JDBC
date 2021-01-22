package com.tjh.jdbc.jdbcBase.day06;

import com.tjh.jdbc.jdbcBase.day03.JDBCUtils01;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Create by koala on 2021-01-19
 *
 * 批量插入的方式三：
 * 1.addBatch()、executeBatch()、clearBatch()
 * 2.mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持。
 * 		 ?rewriteBatchedStatements=true 写在配置文件的url后面
 * 3.使用更新的mysql 驱动：mysql-connector-java-5.1.37-bin.jar
 *
 */
public class InsertTest02 {

    @Test
    public void testInsert1() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            long start = System.currentTimeMillis();

            conn = JDBCUtils01.getConnection();
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

            long end = System.currentTimeMillis();

            System.out.println("花费的时间为：" + (end - start));//20000:83065 -- 565
        } catch (Exception e) {								     //1000000:16086
            e.printStackTrace();
        }finally{
            JDBCUtils01.closeResource(conn, ps);
        }

    }

}
