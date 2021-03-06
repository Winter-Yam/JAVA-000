package my.homework.async;


import my.homework.Fibonacci;
import my.homework.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

/**
 * Thread方法
 */
public class AsyncByThread implements Callbackable {

    private volatile Integer result = null;

    public static void main(String[] args) throws Exception {

        Output.print(new AsyncByThread());
    }

    public Integer asyncExec() throws Exception{
        Thread thread = new Thread(() -> {
            result = Fibonacci.sum();
        }); 
        thread.start();

        while (result==null){
            continue;
        }

        return result;
    };
}
