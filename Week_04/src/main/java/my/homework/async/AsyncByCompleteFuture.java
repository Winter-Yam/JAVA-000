package my.homework.async;


import com.sun.xml.internal.ws.util.CompletedFuture;
import my.homework.Fibonacci;
import my.homework.Output;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;

/**
 * CompleteFuture方法
 */
public class AsyncByCompleteFuture implements Callbackable {

    public static void main(String[] args) throws Exception {

        Output.print(new AsyncByCompleteFuture());
    }

    public Integer asyncExec() throws Exception{
        Integer result = CompletableFuture.supplyAsync(() -> Fibonacci.sum()).join();

        return result;
    };
}
