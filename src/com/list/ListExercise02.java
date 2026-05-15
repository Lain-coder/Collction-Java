package com.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListExercise02 {
    public static void main(String[] args) {
        List list = new ArrayList();
//        List list = new LinkedList();
//        List list = new Vector();

        list.add(new Book("红楼梦", "曹雪芹", 100));
        list.add(new Book("西游记", "吴承恩", 10));
        list.add(new Book("水浒传", "施耐庵", 9));
        list.add(new Book("三国演义", "罗贯中", 80));
        list.add(new Book("西游记", "吴承恩", 10));

        //如何对集合排序


        //遍历
//        for (Object o : list) {
//            System.out.println(o);
//        }
        list.forEach(System.out::println);//等价于上 0o 1lIL

        //冒泡排序

        sort(list);
        System.out.println(" ++++排序后++++");
        list.forEach(System.out::println);
    }

    //静态方法
    /*什么是静态方法（static 方法）

静态方法就是：

不需要创建对象，也能直接调用的方法*/
    //要求从小到大价格排序
    public static void sort(List<Book> list) {

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);

//                Object o =  list.get(j);
                //关于什么时候需要向下转型  ↑
                /*你可以这样快速判断
                    看左边！

                    比如：

                    Object obj = new Book();

                    真正决定你能调用什么的：

                    是左边：

                    Object

                    不是右边。

                    口诀（真的实用）
                    左边是谁，只能用谁的方法
                    想用子类功能，就向下转型*/


                if (book1.price > book2.price) {
                    list.set(j, book2);
                    list.set(j + 1, book1);
                }
            }
        }
    }
}
