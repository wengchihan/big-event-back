package com.andre.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * ThreadLocal 工具类
 */
@SuppressWarnings("all")
public class ThreadLocalUtil {
    // 提供ThreadLocal物件 全域
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    // 根據key 獲取 value
    public static <T> T get(){
        return (T) THREAD_LOCAL.get();
    }
	
    // 存儲 key value
    public static void set(Object value){
        THREAD_LOCAL.set(value);
    }


    // 清楚ThreadLocal 防止記憶體流失 memory leak
    public static void remove(){
        THREAD_LOCAL.remove();
    }
}
