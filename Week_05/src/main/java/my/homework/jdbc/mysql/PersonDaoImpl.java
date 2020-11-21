package my.homework.jdbc.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PersonDaoImpl {

    public static List<Person> list(){
        String sql = "";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        try {
            conn = ConnectionFactory.getConnection();
            sql = "select * from person";
            stmt = conn.prepareStatement(sql);

            // 执行SQL
            //stmt.execute();服务器活跃会话数
            resultSet = stmt.executeQuery();

            // 处理结果集
            List<Person> list = new ArrayList<>();
            while (resultSet.next()) {
                Person person = new Person();

                String sno = resultSet.getString(1);
                String name = resultSet.getString(2);
                person.setSno(sno);
                person.setName(name);

                list.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                stmt.close();
                resultSet.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 批量新增
     */
    public void insert(List<Person> persons){
        Connection conn = null;
        PreparedStatement preStatment = null;

        String sql = "INSERT INTO person values(?, ?)";


        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            preStatment = conn.prepareStatement(sql);

            // 构建SQL语句
            for (Person person : persons) {
                preStatment.setString(1,person.getSno());
                preStatment.setString(2,person.getName());
                preStatment.addBatch();
            }

            // 执行SQL
            preStatment.executeBatch();
            conn.commit();
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

    /**
     * 批量修改
     */
    public void update(List<Person> persons){
        Connection conn = null;
        PreparedStatement preStatment = null;
        String sql = "UPDATE person set name = ? where sno = ?";
        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            preStatment = conn.prepareStatement(sql);

            for (Person person : persons) {
                preStatment.setString(2,person.getSno());
                preStatment.setString(1,person.getName());
                preStatment.addBatch();
            }

            preStatment.executeBatch();
            conn.commit();
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

    /**
     * 批量删除
     */
    public void delete(List<Person> persons){
        Connection conn = null;
        PreparedStatement preStatment = null;

        String sql = "DELETE FROM person where sno = ?";
        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            preStatment = conn.prepareStatement(sql);

            for (Person person : persons) {
                preStatment.setString(1,person.getSno());
                preStatment.addBatch();
            }

            preStatment.executeBatch();
            conn.commit();
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
