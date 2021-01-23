package my.homework.mq.core;

import lombok.SneakyThrows;

import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MyArrayQueue<T> {

    private final T[] array;

    private String topic;

    private int capacity;

    int count;
    int takeIndex;
    int putIndex;

    // 防止并发入队出队，添加重入锁
    private final ReentrantLock lock;

    public MyArrayQueue(String topic, int capacity) {
        this.topic = topic;
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        lock = new ReentrantLock();
    }

    public boolean send(T message) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if (count == array.length)
                return false;
            else {
                array[putIndex] = message;
                if (++putIndex == array.length) {
                    putIndex = 0;
                }
                count++;
                return true;
            }
        } finally {
            lock.unlock();
        }
    }

    public T poll() {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            if(count==0){
                return null;
            }else{
                T x = (T) array[takeIndex];
                array[takeIndex] = null;
                if (++takeIndex == array.length) {
                    takeIndex = 0;
                }
                count--;
                return x;
            }
        } finally {
            lock.unlock();
        }
    }

    public T poll(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == 0) {
                if (nanos <= 0) {
                    return null;
                }
            }
            T x = (T) array[takeIndex];
            array[takeIndex] = null;
            if (++takeIndex == array.length) {
                takeIndex = 0;
            }
            count--;
            return x;
        } finally {
            lock.unlock();
        }
    }

}
