package com.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExercise {
    public static void main(String[] args) {
        List list = new ArrayList();

        for (int i = 0; i < 12; i++) {
            list.add("hello" + i);
        }

        //第二个元素插入“Lain教育”
        list.add(1, "Lain教育");
        //获得第五个元素
        System.out.println("获得第五个元素 = " + list.get(4));
        //删除第六个元素
        list.remove(5);
        System.out.println("list = " + list);
        //修改第七个元素
        list.set(6,"三国演义");
        System.out.println("list = " + list);

//       Iterator iterator = list.iterator();
//        while (iterator.hasobj()) {
//            Object obj =  iterator.obj();
//            System.out.println("obj = " + obj);
//
//        }
        list.forEach(System.out::println);




    }
}
