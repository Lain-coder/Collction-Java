package com.list;

import java.util.ArrayList;
import java.util.List;

public class ListFor {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("list = " + list);
        //iterator
        System.out.println("iterator遍历  " );
        list.iterator().forEachRemaining(System.out::println);

        //增强for
        System.out.println("增强for遍历   " );
        list.forEach(System.out::println);

        //普通for
        System.out.println("普通for遍历   " );
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list.get(i) = " + list.get(i));

        }
    }
}
