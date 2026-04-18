package com.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add(new Book("The Great Gatsby","F. Scott Fitzgerald",100));
        collection.add(new Book("1984","George Orwell",50));
        collection.add(new Book("Harry Potter and the Philosopher’s Stone","J. K. Rowling",25));

        System.out.println("collection = " + collection);
        Iterator iterator = collection.iterator();//定义迭代器
        /*
        迭代器在干什么：迭代器类似指针在数组里面遍历元素，
        好处：迭代器为遍历提供了一种专门用来“安全、统一”遍历集合的工具
        为什么要用迭代器：因为不懂集合遍历方式不一样
        */
        System.out.println("第一次遍历");
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book);

        }
        //指针位置重置，因为一次访问到最后一个元素之后指针就不动了再向下访问会抛出异常，需要重置指针位置
        iterator = collection.iterator();
        System.out.println("第二次遍历");
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book);
        }
    }

   static class  Book {
        private String name;
        private String author;
        private int price;

        public Book(String name, String author, int price) {
            this.name = name;
            this.author = author;
            this.price = price;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Book{name='" + name + "', author='" + author + "', price=" + price + "}";
        }
    }
}