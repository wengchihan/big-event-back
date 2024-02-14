package com.andre;

import org.junit.jupiter.api.Test;

/**
 * ClassName: ThreadLocalTest
 * Package: com.andre
 * Description:
 *
 * @Author: Andre
 * @Create: 2024/1/6 - 17:21
 * @Version: v1.0
 */
public class ThreadLocalTest {

    @Test
    public void testThreadLocalSetAndGet() {
        // 提供一個ThreadLocal物件
        //ThreadLocal tl = new ThreadLocal();
        //
        //// 開啟兩個執行緒
        //new Thread(() -> {
        //    tl.set("台北");
        //    System.out.println(Thread.currentThread().getName() + ": " + tl.get());
        //    System.out.println(Thread.currentThread().getName() + ": " + tl.get());
        //    System.out.println(Thread.currentThread().getName() + ": " + tl.get());
        //}, "藍色").start();
        //
        //new Thread(() -> {
        //    tl.set("台南");
        //    System.out.println(Thread.currentThread().getName() + ": " + tl.get());
        //    System.out.println(Thread.currentThread().getName() + ": " + tl.get());
        //    System.out.println(Thread.currentThread().getName() + ": " + tl.get());
        //}, "綠色").start();
    }

}
