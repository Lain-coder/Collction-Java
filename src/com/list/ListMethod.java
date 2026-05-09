package com.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListMethod {
    /* List接口提供了一系列方法来操作集合中的元素：

    添加元素：add(E e)、addAll(Collection<? extends E> c)

    访问元素：get(int index)、set(int index, E element)

    删除元素：remove(Object o)、remove(int index)

    搜索：indexOf(Object o)、lastIndexOf(Object o)

    迭代：listIterator()、listIterator(int index)

    范围操作：subList(int fromIndex, int toIndex)
    *///list实现方法有哪些

    public static void main(String[] args) {

        // 创建List
        List<String> list = new ArrayList<>();


        /*
         * 添加元素：add(E e)
         */
        list.add("张三");
        list.add("李四");

        System.out.println("add后：" + list);



        /*
         * 添加多个元素：addAll(Collection<? extends E> c)
         */
        List<String> list2 = Arrays.asList("王五", "赵六");

        list.addAll(list2);

        System.out.println("addAll后：" + list);



        /*
         * 访问元素：get(int index)
         */
        String name = list.get(0);

        System.out.println("get获取：" + name);



        /*
         * 修改元素：set(int index, E element)
         */
        list.set(1, "老李");

        System.out.println("set修改后：" + list);



        /*
         * 删除元素：remove(Object o)
         */
        list.remove("王五");

        System.out.println("remove对象后：" + list);



        /*
         * 删除元素：remove(int index)
         */
        list.remove(0);

        System.out.println("remove下标后：" + list);



        /*
         * 搜索：indexOf(Object o)
         * 返回第一次出现的位置
         */
        list.add("赵六");
        list.add("赵六");

        int first = list.indexOf("赵六");

        System.out.println("第一次出现位置：" + first);



        /*
         * 搜索：lastIndexOf(Object o)
         * 返回最后一次出现的位置
         */
        int last = list.lastIndexOf("赵六");

        System.out.println("最后一次出现位置：" + last);



        /*
         * 迭代：listIterator()
         */
        ListIterator<String> iterator = list.listIterator();

        System.out.println("listIterator遍历：");

        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }



        /*
         * 迭代：listIterator(int index)
         * 从指定位置开始遍历
         */
        ListIterator<String> iterator2 = list.listIterator(1);

        System.out.println("从下标1开始遍历：");

        while (iterator2.hasNext()) {
            String s = iterator2.next();
            System.out.println(s);
        }



        /*
         * 范围操作：subList(int fromIndex, int toIndex)
         * 包含fromIndex，不包含toIndex
         */
        List<String> sub = list.subList(0, 2);

        System.out.println("subList结果：" + sub);
    }

}
