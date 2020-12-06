package my.homework.dynamic.service;

import my.homework.dynamic.Goods;
import my.homework.insert.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class GoodsShardingService {

    @Autowired
    private DataSource dataSource;

    public void insert(){
        Connection conn = null;
        PreparedStatement preStatment = null;

        String sql = "INSERT INTO goods values(?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try {
            conn = dataSource.getConnection();

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
                // 执行SQL
                preStatment.execute();
            }

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
