package my.homework.mq.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class KmqBroker { // Broker+Connection

    public static final int CAPACITY = 10000;

    private final Map<String, MyArrayQueue> kmqMap = new ConcurrentHashMap<>(64);

    public void createTopic(String name){
        kmqMap.putIfAbsent(name, new MyArrayQueue(name,CAPACITY));
    }

    public MyArrayQueue findKmq(String topic) {
        return this.kmqMap.get(topic);
    }

    public KmqProducer createProducer() {
        return new KmqProducer(this);
    }

    public KmqConsumer createConsumer() {
        return new KmqConsumer(this);
    }

}
