package my.homework.jdbc.gaussdb;

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
                for (int j = 8700; j < 100000; j++) {
                    String s = "'"+j+"'";
                    sql = "select id from test.cc where id = "+j;
                    stmt = conn.prepareStatement(sql);

                    // 执行SQL
                    //stmt.execute();服务器活跃会话数
                    resultSet = stmt.executeQuery();

                    // 处理结果集
                    List<Person> list = new ArrayList<>();
                    while (resultSet.next()) {
                        Person person = new Person();

                        String sno = resultSet.getString(1);
                        person.setSno(sno);

                        list.add(person);
                    }
                    System.out.println("执行次数"+j);
                }

                //return list;
            } catch (SQLException e) {
                e.printStackTrace();
                //return Collections.EMPTY_LIST;
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

    public static void main(String[] args) {
        list();
    }

    public void insert(Person person){
        String sql = "INSERT INTO person values(?, ?)";
        try(
                // 获取连接
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement preStatment = conn.prepareStatement(sql)
        ){
            // 构建SQL语句
            preStatment.setString(1,person.getSno());
            preStatment.setString(2,person.getName());

            // 执行SQL
            preStatment.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
