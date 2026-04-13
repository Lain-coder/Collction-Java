package com.collection;

import java.util.ArrayList;

import java.util.List;

/*Collection接口和常用方法*/

public class CollectionMethod {
    public static void main(String[] args) {
        List list = new ArrayList();//添加单个元素
        //add
        list.add("jack");
        list.add(10);
        list.add(true);
        System.out.println(list);
        //remove
        list.remove("jack");
        list.remove(1);
        list.remove(true);
        System.out.println(list);
        //contains查找元素存在与否，布尔值
//        list.contains("jack");
        System.out.println(list.contains(10));
        //size获得元素个数
        System.out.println(list.size());
        //isEmpty判断是否为空
        System.out.println(list.isEmpty());
        //clear
        list.clear();
        System.out.println("list = " + list);
        //addAll添加多个元素,放一个集合进去
        ArrayList list2 = new ArrayList<>();
        list2.add("Tom");
        list2.add(67);
        list2.add(false);
        list.addAll(list2);
        System.out.println("list = " + list);
        //containsAll查找多个元素是否存在
        System.out.println(list.containsAll(list2));
        //removeAll删除多个元素
        list.add("Jerry");
        list.removeAll(list2);
        System.out.println(list);


    }
}
