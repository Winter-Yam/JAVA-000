package my.homework.insert;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchInsertTest {

    /**
     * 批量插入
     */
    public void insert(){
        Connection conn = null;
        PreparedStatement preStatment = null;

        String sql = "INSERT INTO goods values(?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try {
            conn = ConnectionFactory.getConnection();

            preStatment = conn.prepareStatement(sql);

            // 构建SQL语句
            for(int i = 1; i<=1000000; i++){
                preStatment.setLong(1, i);
                preStatment.setInt(2, i);
                preStatment.setInt(3, i);
                preStatment.setString(4, "i_"+i);
                preStatment.setString(5, "测试商品"+i);
                preStatment.setBigDecimal(6, new BigDecimal(i));
                preStatment.setInt(7, i);
                preStatment.setBigDecimal(8, new BigDecimal(i*i));
                preStatment.setString(9, "广州"+i);
                preStatment.addBatch();
            }

            // 执行SQL
            preStatment.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.rollback();

                conn.close();
                preStatment.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
