package com.list;

import java.util.ArrayList;
import java.util.List;

public class List_ {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("jack");
        list.add("burger");
        list.add("marry");
        list.add("herry");
        list.add("lain");

        System.out.println("list = "+ list);
        list.lastIndexOf("jack");
        //按索引查找
        System.out.println(list.get(1));

        list.remove(1);
        System.out.println("list = " + list);

        list.subList(2,3).clear();//左闭右开区间范围
        System.out.println("list = " + list);
    }

}
