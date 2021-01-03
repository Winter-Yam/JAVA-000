package my.homework.redis.counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Component
public class RStock {

    private static final String lua = "" +
            "if redis.call('get', KEYS[1]) >= ARGV[1] " +
            "then " +
            "   return redis.call('decrby',KEYS[1], ARGV[1])" +
            "else " +
            "   return -1 " +
            "end";
    private static final DefaultRedisScript<Long> script;

    static{
        script = new DefaultRedisScript<>(lua, Long.class);
    }

    @Autowired
    private RedisTemplate redisTemplate;

    public void init(String key, String capital){
        redisTemplate.opsForValue().set(key, capital);
    }

    /**
     * 使用LUA脚本
     * @param key
     * @param delta
     * @return
     */
    public Long decrStock1(String key, String delta){
        // 使用lua脚本方式查询是否够库存，并扣减
        Long result = (Long)redisTemplate.execute(script, Collections.singletonList(key), delta);
        if(result == null || result<0){
            throw new RuntimeException("库存不足");
        }
        return result;
    }

    /**
     * 不使用锁，而是采用恢复库存方式处理并发
     * @param key
     * @param delta
     * @return
     */
    public Long decrStock2(String key, Long delta){
        // 查询当前库存是否足够扣减
        Long currentStock = (Long) redisTemplate.opsForValue().get(key);
        if(currentStock==null||currentStock<delta){
            throw new RuntimeException("库存不足");
        }
        Long stock = redisTemplate.opsForValue().decrement(key, delta);

        // 如果扣减后库存少于0，则说明中间有其他人买入，恢复原来的库存
        if(stock<0){
            redisTemplate.opsForValue().increment(key,delta);
            throw new RuntimeException("请重新操作");
        }
        return stock;
    }
}
