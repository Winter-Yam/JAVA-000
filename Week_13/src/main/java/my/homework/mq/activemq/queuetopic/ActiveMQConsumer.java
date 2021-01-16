package my.homework.mq.activemq.queuetopic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQConsumer {

    @JmsListener(destination = "myqueuue")
    public void receive(String message) {
        System.out.println("收到的 message 是：" + message);
    }
}
