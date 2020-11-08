package my.homework.async;


import my.homework.Fibonacci;
import my.homework.Output;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask方法
 */
public class AsyncByCallable implements Callbackable {

    public static void main(String[] args) throws Exception {

        Output.print(new AsyncByCallable());
    }

    public Integer asyncExec() throws Exception{
        FutureTask<Integer> fiboTask = new FutureTask<>(
                () -> Fibonacci.sum()
        );
        fiboTask.run();

        while (!fiboTask.isDone()){
            continue;
        }
        return fiboTask.get();
    };
}
