package my.homework.redis;

import my.homework.redis.lock.RLock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RLockTest {

    @Autowired
    private RLock redisLock;

    @Test
    public void testNode1() throws Exception {
        while(!redisLock.getLock("testlock")){
            Thread.sleep(1000);
            System.out.println("节点1获取锁失败");
        }

        System.out.println("节点1获取锁");
        Thread.sleep(15000);
        if(!redisLock.releaseLock("testlock")){
            System.out.println("节点1释放锁失败");
        }else{
            System.out.println("节点1释放锁成功");
        }
    }

    @Test
    public void testNode2() throws Exception {
        while(!redisLock.getLock("testlock")){
            Thread.sleep(1000);
            System.out.println("节点2获取锁失败");
        }

        System.out.println("节点2获取锁");
        Thread.sleep(15000);
        if(!redisLock.releaseLock("testlock")){
            System.out.println("节点2释放锁失败");
        }else{
            System.out.println("节点2释放锁成功");
        }
    }
}
