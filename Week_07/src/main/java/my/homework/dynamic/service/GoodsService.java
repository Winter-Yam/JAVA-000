package my.homework.dynamic.service;

import my.homework.dynamic.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private JdbcTemplate masterJdbcTemplate;

    @Autowired
    private JdbcTemplate slaveJdbcTemplate;

    public void insert(){
        String sql = "insert into goods values(?,?,?,?,?)";
        Goods goods = new Goods().init();

        masterJdbcTemplate.update(sql, goods);
    }

    public void select(){
        String sql = "select * from goods";
        List<Goods> goodsList = slaveJdbcTemplate.queryForList(sql, Goods.class);
    }
}
