### 实现一个简单的分布式锁
`my.homework.redis.lock`
- 使用redisTemplate封装的API实现分布式锁
- 使用LUA脚本实现并发安全的锁释放


### 实现一个分布式计数器，模拟减库存
`my.homework.redis.counter`

提供两种处理方式
- 基于LUA脚本，防止查询后的并发修改
- Java代码实现，在出现并发问题后进行回滚


### 实现基于Redis 的 PubSub 实现订单异步处理
`my.homework.redis.pubsub`
- 使用redisTemplate提供的convertAndSend进行消息发布
- 使用MessageListenerAdapter进行接收者的绑定