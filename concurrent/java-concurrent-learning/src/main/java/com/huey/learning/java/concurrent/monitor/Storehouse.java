package com.huey.learning.java.concurrent.monitor;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 仓库
 *
 * @author huey
 */
public class Storehouse {

    // 缓冲区
    private final Queue<Object> buffer;
    // 仓库最多允许存储 capacity 个物品
    private final int capacity;

    public Storehouse(int capacity) {
        if (capacity <= 0 || capacity > 100) {
            throw new IllegalArgumentException("capacity 参数的值必须在 1 到 100之间");
        }
        this.capacity = capacity;
        this.buffer = new LinkedList<>();
    }

    /**
     * 输入物品
     *
     * @param data
     * @throws InterruptedException
     */
    public synchronized void input(Object data) throws InterruptedException {
        while (this.isFull()) {
            System.out.printf("仓库当前处于饱和状态，生产者 %s 须挂起等待。\n", Thread.currentThread().getName());
            this.wait();
        }
        buffer.offer(data);
        System.out.printf("%s 输入物品，仓库当前有 %d 个物品。\n", Thread.currentThread().getName(), this.size());
        this.notifyAll();
    }

    /**
     * 输出物品
     *
     * @throws InterruptedException
     */
    public synchronized void output() throws InterruptedException {
        while (this.isEmpty()) {
            System.out.printf("仓库当前处于空虚状态，消费者 %s 须挂起等待。\n", Thread.currentThread().getName());
            this.wait();
        }
        buffer.poll();
        System.out.printf("%s 输出物品，仓库当前有 %d 个物品。\n", Thread.currentThread().getName(), this.size());
        this.notifyAll();
    }

    /**
     * 当前仓库占用大小
     *
     * @return
     */
    public int size() {
        return buffer.size();
    }

    /**
     * 仓库是否空虚
     *
     * @return
     */
    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    /**
     * 仓库是否饱和
     *
     * @return
     */
    public boolean isFull() {
        return buffer.size() == capacity;
    }

}