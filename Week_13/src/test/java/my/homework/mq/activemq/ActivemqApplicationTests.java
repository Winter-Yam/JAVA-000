package my.homework.mq.activemq;

import my.homework.mq.activemq.queue.P2PConsumer;
import my.homework.mq.activemq.queue.P2PProvider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class ActivemqApplicationTests {

    @Resource
    private P2PProvider p2pProvider;
    @Resource
    private P2PConsumer p2pConsumer;

    @Test
    private void testP2p() {
        System.out.println("==");
        p2pProvider.send("==test==");

    }

}
