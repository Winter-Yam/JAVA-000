package my.homework.jdbc.service;


import my.homework.jdbc.entity.Goods;
import my.homework.jdbc.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    public void insert(Goods goods){
        goodsMapper.insert(goods);
    }

    public List<Goods> list(){
        return goodsMapper.listAll();
    }

    public void update(Goods goods){
        goodsMapper.update(goods);
    }

    public void delete(Long id){
        goodsMapper.delete(id);
    }


}
