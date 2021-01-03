package my.homework.redis;

import my.homework.redis.counter.RStock;
import my.homework.redis.pubsub.RedisSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PubsubTest {

    @Autowired
    private RedisSender redisSender;

    @Test
    public void testPubsub() throws Exception {
        redisSender.publish();
    }
}
