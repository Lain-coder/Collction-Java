package com.list;

import java.util.ArrayList;

/* ArrayList 在容量不足时会触发扩容机制，按 1.5倍增长 创建新数组，并通过 Arrays.copyOf() 将旧数据拷贝到新数组中，从而实现动态扩容。*/


public class ArrayListSource {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);
    }
}

/**
 * ArrayList 扩容机制完整说明（源码级+注释版）
 */
/*
public class ArrayListGrowDemo {

    // 默认初始容量
    private static final int DEFAULT_CAPACITY = 10;

    // 最大数组容量（接近 Integer.MAX_VALUE）
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    // 真正存储数据的数组
    private Object[] elementData;

    // 当前元素个数
    private int size;

    */
/**
     * 添加元素（触发扩容入口）
     *//*

    public boolean add(Object e) {

        // 1. 确保容量足够（核心入口）
        ensureCapacityInternal(size + 1);

        // 2. 放入元素
        elementData[size++] = e;

        return true;
    }

    */
/**
     * 内部容量检查
     *//*

    private void ensureCapacityInternal(int minCapacity) {

        // 如果是第一次使用（空数组）
        if (elementData == null || elementData.length == 0) {
            // 默认至少扩容到 10
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }

    */
/**
     * 判断是否需要扩容
     *//*

    private void ensureExplicitCapacity(int minCapacity) {

        // modCount++（源码里用于 fail-fast 机制，防止并发修改）
        // modCount++;

        // 如果需要的最小容量 > 当前数组长度 → 扩容
        if (minCapacity > elementData.length) {
            grow(minCapacity);
        }
    }

    */
/**
     * ⭐ 核心扩容方法（重点）
     *//*

    private void grow(int minCapacity) {

        int oldCapacity = elementData.length;

        */
/**
         * ⭐ 扩容规则：1.5 倍
         * old + old/2
         *//*

        int newCapacity = oldCapacity + (oldCapacity >> 1);

        // 如果 1.5 倍还不够，直接用需求值
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }

        // 防止数组越界（超过 JVM 限制）
        if (newCapacity > MAX_ARRAY_SIZE) {
            newCapacity = hugeCapacity(minCapacity);
        }

        // ⭐ 创建新数组，并拷贝旧数据
        elementData = java.util.Arrays.copyOf(elementData, newCapacity);
    }

    */
/**
     * 超大容量处理
     *//*

    private int hugeCapacity(int minCapacity) {
        if (minCapacity > MAX_ARRAY_SIZE) {
            return Integer.MAX_VALUE;
        }
        return MAX_ARRAY_SIZE;
    }
}*/
