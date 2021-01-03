package my.homework.redis.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisSender {

    @Autowired
    private RedisTemplate redisTemplate;

    public void publish(){
        redisTemplate.convertAndSend("mytopic", 100);
        System.out.println("下单成功");
    }
}
