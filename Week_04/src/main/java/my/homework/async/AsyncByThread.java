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

    public static void main(String[] args) throws Exception {

        Output.print(new AsyncByThread());
    }

    public Integer asyncExec() throws Exception{
        List<Integer> list = new ArrayList<>();
        Thread thread = new Thread(() -> {
            list.add(Fibonacci.sum());
        });
        thread.start();

        while (list.isEmpty()){
            continue;
        }

        return list.get(0);
    };
}
