package my.homework.async;


import my.homework.Fibonacci;
import my.homework.Output;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * CountDownLatch方法
 */
public class AsyncByCountDownLatch implements Callbackable{
    private volatile Integer result = null;

    public static void main(String[] args) throws Exception {

        Output.print(new AsyncByCountDownLatch());
    }

    public Integer asyncExec() throws Exception{
        CountDownLatch latch = new CountDownLatch(1);
        Thread thread = new Thread(() -> {
            result = Fibonacci.sum();
            latch.countDown();
        });
        thread.start();

        latch.await();
        return result;
    }
}
