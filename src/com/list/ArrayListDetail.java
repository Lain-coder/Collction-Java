package com.list;

import java.util.ArrayList;

public class ArrayListDetail {

    public static void main(String[] args) throws InterruptedException {

        // ArrayList 线程不安全：
        // 多个线程同时修改同一个 ArrayList 时
        // 可能出现数据丢失、size错误、甚至报异常

        ArrayList<Integer> list = new ArrayList<>();


        // 线程1：添加10000个数据
        Thread t1 = new Thread(() -> {

            for (int i = 0; i < 10000; i++) {

                // add() 看似一步
                // 实际底层包含：
                // 1. 判断容量
                // 2. 扩容
                // 3. 插入元素
                // 4. size++

                // 多线程同时执行时
                // 这些步骤可能互相抢占

                list.add(i);
            }

        });


        // 线程2：也添加10000个数据
        Thread t2 = new Thread(() -> {

            for (int i = 0; i < 10000; i++) {

                list.add(i);
            }

        });


        // 启动两个线程
        t1.start();
        t2.start();


        // 等待两个线程执行结束
        t1.join();
        t2.join();


        // 理论应该是20000
        // 实际可能：
        // 19873、19991...
        // 甚至直接报错

        System.out.println("最终大小：" + list.size());
    }
}