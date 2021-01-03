package my.homework.redis.pubsub;

public class RedisReceiver {

    public void getMsg(String message) {
        System.out.println("订单ID："+message);
        // TODO 处理下单业务
    }
}
