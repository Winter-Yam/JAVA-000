package my.homework.redis.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class RLock {

    private static final String lockValue = "1";
    private static final int lockExpire = 30;
    private static final DefaultRedisScript<Long> script;

    static{
        String lua = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        script = new DefaultRedisScript<>(lua, Long.class);
    }

    @Autowired
    private RedisTemplate redisTemplate;

    public Boolean getLock(String key){
        Boolean ifAbsent = redisTemplate.opsForValue().setIfAbsent(key, lockValue, lockExpire, TimeUnit.SECONDS);
        return ifAbsent;
    }

    public Boolean releaseLock(String key){
        // 使用lua脚本释放锁
        Object result = redisTemplate.execute(script, Collections.singletonList(key), lockValue);
        return result!=null && result.equals(Long.valueOf(lockValue));
    }
}
