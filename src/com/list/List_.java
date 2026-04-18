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

        System.out.println(list);
        //按索引查找
        System.out.println(list.get(1));
    }

}
