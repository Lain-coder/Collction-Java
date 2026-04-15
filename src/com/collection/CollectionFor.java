package com.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionFor {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add(new CollectionIterator.Book("The Great Gatsby","F. Scott Fitzgerald",100));
        collection.add(new CollectionIterator.Book("1984","George Orwell",50));
        collection.add(new CollectionIterator.Book("Harry Potter and the Philosopher’s Stone","J. K. Rowling",25));

        //1.增强for的使用,在Collection集合
        //2.增强for，底层仍然是迭代器
        //3.增强for可以理解为简化版的迭代器遍历
        for (Object book : collection) {
            System.out.println("book = " + book);
        }

        //4.快捷方式I
//        for (Object o :) {
//
//        }


        //增强for也可以直接在数组使用
        int[] nums = {1,2,3,4,5};
        for (int i : nums) {
            System.out.println("i = " + i);
        }
    }
}
