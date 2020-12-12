package my.homework.jdbc.mapper;

import my.homework.jdbc.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {

    void insert(Goods goods);

    List<Goods> listAll();

    void update(Goods goods);

    void delete(@Param("id") Long id);
}
