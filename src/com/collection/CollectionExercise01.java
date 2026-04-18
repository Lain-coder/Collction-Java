package com.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionExercise01 {
    public static void main(String[] args) {
        List<Dog> List = new ArrayList();
        List.add(new Dog("小狗一号","1岁"));
        List.add(new Dog("小狗二号","2岁"));
        List.add(new Dog("小狗三号","3岁"));

//        System.out.println("List = " + List);

        Iterator iterator = List.iterator();
        while (iterator.hasNext()) {//itit快捷键
            Object dog =  iterator.next();
            System.out.println("dog = " + dog);
        }

        System.out.println("=======这是用增强for======");

        for(Object dog : List){
            System.out.println("dog = " + dog);
        }
    }

    static class Dog{

        private String name;
        private String age;
        public Dog(String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Dog{" + "name='" + name + '\'' + ", age='" + age + '\'' + '}';
        }
    }

}

