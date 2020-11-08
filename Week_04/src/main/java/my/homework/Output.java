package my.homework;

import my.homework.async.Callbackable;

/**
 * 统一输出运行结果
 */
public class Output {

    public static void print(Callbackable callback) throws Exception {

        long start=System.currentTimeMillis();

        // 异步计算`
        Integer result = callback.asyncExec();

        // 输出结果
        System.out.println("异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
    }
}
