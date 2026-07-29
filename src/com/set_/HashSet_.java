package com.set_;

import java.util.HashSet;
import java.util.Set;

public class HashSet_ {
    public static void main(String[] args) {

        // HashSet 的底层实现是 HashMap。
        // HashSet 中每个元素实际作为 HashMap 的 key 存储，
        // value 统一使用一个固定的占位对象。

        // 使用泛型，表示这个集合可以存放任意类型的对象。
        Set<Object> hashSet = new HashSet<>();

        // 1. HashSet 可以存放 null，但最多只能存放一个 null。
        //    第二次 add(null) 会失败，因为 null 也要遵守“不重复”的规则。
        System.out.println(hashSet.add(null)); // true
        System.out.println(hashSet.add(null)); // false

        // 2. HashSet 不允许重复元素。
        //    add() 的返回值为 boolean：
        //    添加成功返回 true；元素已存在、添加失败返回 false。
        System.out.println(hashSet.add(1)); // true
        System.out.println(hashSet.add(1)); // false

        // 例子：内容相同的 String 也不能重复加入。
        // 因为 String 类已经重写 hashCode() 和 equals()。
        System.out.println(hashSet.add(new String("hsp"))); // true
        System.out.println(hashSet.add(new String("hsp"))); // false

        // 3. HashSet 不保证元素的添加顺序和输出顺序。
        //    因此输出顺序不一定和 add() 的顺序一致。
        System.out.println("hashSet = " + hashSet);

        // 4. 判断两个对象是否重复，依赖 hashCode() 和 equals()：
        //    ① 先比较 hashCode()
        //    ② hashCode 相同，再使用 equals() 比较内容
        //
        // 例子：两个 Dog 对象的 name 都是 "Tom"，
        // 但 Dog 没有重写 hashCode() 和 equals()，
        // 所以 HashSet 认为它们是两个不同对象，都能加入。
        hashSet.add(new Dog("Tom"));
        hashSet.add(new Dog("Tom"));

        System.out.println("添加 Dog 后 = " + hashSet);

        // 所以，自定义类若想按照“属性内容”去重，
        // 通常需要同时重写 hashCode() 和 equals()。
    }
}

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{name='" + name + "'}";
    }
}
