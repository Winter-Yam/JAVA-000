package my.homework.async;


import my.homework.Fibonacci;
import my.homework.Output;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 线程池执行异步方法
 */
public class AsyncByThreadPool implements Callbackable {

    public static void main(String[] args) throws Exception {

        Output.print(new AsyncByThreadPool());
    }

    public Integer asyncExec() throws Exception{
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        Future<Integer> fiboFuture = threadPool.submit(() -> Fibonacci.sum());

        while (!fiboFuture.isDone()){
            continue;
        }
        threadPool.shutdown();
        return fiboFuture.get();
    };
}
