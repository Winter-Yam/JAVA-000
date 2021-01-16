package my.homework.mq.activemq.queue;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;

@Component
public class P2PProvider {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void send(String msg) {
        jmsMessagingTemplate.convertAndSend(queue,msg);
        System.out.println("点对点通讯，msg="+msg);
    }

    public void sendTopicMsg(String msg){
        ActiveMQTopic destination = new ActiveMQTopic("mytopic");
        jmsMessagingTemplate.convertAndSend(destination,msg);
        System.out.println("发布订阅通讯，msg="+msg);
    }
}
