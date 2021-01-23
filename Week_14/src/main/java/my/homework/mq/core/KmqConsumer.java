package my.homework.mq.core;

import java.util.concurrent.TimeUnit;

public class KmqConsumer<T> {

    private final KmqBroker broker;

    private MyArrayQueue<KmqMessage> kmq;

    public KmqConsumer(KmqBroker broker) {
        this.broker = broker;
    }

    public void subscribe(String topic) {
        this.kmq = this.broker.findKmq(topic);
        if (null == kmq) throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
    }

    public KmqMessage<T> poll(long timeout) throws Exception {
        return kmq.poll(timeout, TimeUnit.NANOSECONDS);
    }

}
