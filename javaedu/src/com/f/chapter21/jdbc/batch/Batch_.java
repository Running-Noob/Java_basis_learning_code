package com.f.chapter21.jdbc.batch;

import com.f.chapter21.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author fzy
 * @date 2023/8/7 16:06
 * 演示Java进行批处理和不进行批处理的区别
 */
public class Batch_ {
    @Test
    public void noBatch() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO admin VALUES (null, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        //执行五千次insert操作
        long start = System.currentTimeMillis();    //执行开始时间
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "tom" + i);
            preparedStatement.setString(2, "123456" + i);
            preparedStatement.executeUpdate();
        }
        long end = System.currentTimeMillis();    //执行结束时间
        System.out.println("执行总耗时 = " + (end - start)); //执行总耗时 = 7420
        JDBCUtils.close(null, preparedStatement, connection);
    }

    @Test
    public void batch() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO admin VALUES (null, ?, ?)";
        preparedStatement = connection.prepareStatement(sql);
        //执行五千次insert操作
        long start = System.currentTimeMillis();    //执行开始时间
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "tom" + i);
            preparedStatement.setString(2, "123456" + i);
            /**
             * 将sql语句加入到批处理包batchedArgs中：
             *     public void addBatch() throws SQLException {
             *         synchronized(this.checkClosed().getConnectionMutex()) {
             *             if (this.batchedArgs == null) {
             *                 //创建ArrayList, 里面将要存放的是PreparedStatement$BatchParams对象，即预处理的sql语句
             *                 this.batchedArgs = new ArrayList();
             *             }
             *
             *             //对PreparedStatement传入的参数进行校验并对相应的sql进行预处理
             *             for(int i = 0; i < this.parameterValues.length; ++i) {
             *                 this.checkAllParametersSet(this.parameterValues[i], this.parameterStreams[i], i);
             *             }
             *
             *             this.batchedArgs.add(new BatchParams(this.parameterValues, this.parameterStreams, this.isStream, this.streamLengths, this.isNull));
             *         }
             *     }
             * */
            preparedStatement.addBatch();
            //当batch中有1000条记录时，再批量执行
            if ((i + 1) % 1000 == 0) {
                preparedStatement.executeBatch();
                //批量执行结束后，清空batch
                preparedStatement.clearBatch();
            }
        }
        long end = System.currentTimeMillis();    //执行结束时间
        System.out.println("执行总耗时 = " + (end - start)); //执行总耗时 = 100
        JDBCUtils.close(null, preparedStatement, connection);
    }
}
