package my.homework.async;


import my.homework.Fibonacci;
import my.homework.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * CycicBarrier方法
 */
public class AsyncByCyclicBarrier implements Callbackable{
    private volatile Integer result = null;

    public static void main(String[] args) throws Exception {

        Output.print(new AsyncByCyclicBarrier());
    }

    public Integer asyncExec() throws Exception{
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, () -> {
            result=Fibonacci.sum();
        });
        cyclicBarrier.await();
        return result;
    }
}
