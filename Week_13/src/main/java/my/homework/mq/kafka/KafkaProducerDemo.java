package my.homework.mq.kafka;

import io.kimmking.javacourse.kafka.kimmking.ConsumerImpl;
import io.kimmking.javacourse.kafka.kimmking.ProducerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerDemo {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    @RequestMapping("message/send")
    public String send(String msg){
        kafkaTemplate.send("testk", msg);
        return "success";
    }
}
