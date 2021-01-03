package my.homework.redis;

import my.homework.redis.counter.RStock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RStockTest {

    @Autowired
    private RStock redisStock;

    /**
     * 正常扣减库存
     * @throws Exception
     */
    @Test
    public void testNormal() throws Exception {
        redisStock.init("stock", "10");
        Long stock = redisStock.decrStock1("stock", "1");
        System.out.println(stock);
    }

    /**
     * 库存超卖
     * @throws Exception
     */
    @Test
    public void testAbnormal() throws Exception {
        redisStock.init("stock", "10");
        Long stock = redisStock.decrStock1("stock", "11");
        System.out.println(stock);
    }
}
