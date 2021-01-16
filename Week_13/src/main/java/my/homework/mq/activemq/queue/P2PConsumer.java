package my.homework.mq.activemq.queue;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class P2PConsumer {

    @JmsListener(destination = "myqueuue")
    public void receive(String message) {
        System.out.println("收到的 message 是：" + message);
    }
}
