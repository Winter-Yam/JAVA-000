package my.homework.mq.kafka;

import io.kimmking.javacourse.kafka.kimmking.ConsumerImpl;
import io.kimmking.javacourse.kafka.kimmking.ProducerImpl;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerDemo {
    /**
     * 定义此消费者接收topics = "demo"的消息，与controller中的topic对应上即可
     * @param record 变量代表消息本身，可以通过ConsumerRecord<?,?>类型的record变量来打印接收的消息的各种信息
     */
    @KafkaListener(topics = "testk")
    public void listen (ConsumerRecord<?, ?> record){
        System.out.printf("topic is %s, offset is %d, value is %s \n", record.topic(), record.offset(), record.value());
    }
}
