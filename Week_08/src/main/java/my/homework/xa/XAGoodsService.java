package my.homework.xa;


import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlMasterSlaveDataSourceFactory;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class XAGoodsService {

    private final DataSource dataSource;

    /**
     * 初始化XA数据源
     * @param yamlConfigFile
     * @throws Exception
     */
    public XAGoodsService(String yamlConfigFile) throws Exception {
        dataSource = YamlMasterSlaveDataSourceFactory.createDataSource(new File(XAGoodsService.class.getClassLoader().getResource(yamlConfigFile).getFile()));
    }

    /**
     * XA执行成功.
     *
     * @throws SQLException SQL exception
     */
    public void insert() throws SQLException {
        TransactionTypeHolder.set(TransactionType.XA);
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO t_order (user_id) VALUES (?)");
            for (int i = 0; i < 20; i++) {
                preparedStatement.setObject(1, i);
                preparedStatement.executeUpdate();
            }
            connection.commit();
        } finally {
            TransactionTypeHolder.clear();
        }
    }

    /**
     * XA回滚.
     *
     * @throws SQLException SQL exception
     */
    public void insertFailed() throws SQLException {
        TransactionTypeHolder.set(TransactionType.XA);
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO t_order (user_id) VALUES (?)");
            for (int i = 0; i < 20; i++) {
                preparedStatement.setObject(1, i);
                preparedStatement.executeUpdate();
            }
            connection.rollback();
        } finally {
            TransactionTypeHolder.clear();
        }
    }

}
