package com.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArrayList 扩容机制演示。
 * 配套笔记：docs/arraylist-growth.md
 *
 * <p>JDK 的 ArrayList 在容量不足时会创建新数组，并通过 Arrays.copyOf()
 * 把旧数据复制到新数组。无参构造的 ArrayList 第一次添加元素时默认扩到 10，
 * 后续通常按 1.5 倍增长。</p>
 */
public class ArrayListSource {
    public static void main(String[] args) {
        useJdkArrayList();
        System.out.println("==========");
        showGrowProcess();
    }

    private static void useJdkArrayList() {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= 15; i++) {
            list.add(i);
        }
        list.add(100);
        list.add(200);
        list.add(null);

        System.out.println("JDK ArrayList 元素个数: " + list.size());
        System.out.println("JDK ArrayList 内容: " + list);
    }

    private static void showGrowProcess() {
        SimpleArrayList list = new SimpleArrayList();

        for (int i = 1; i <= 18; i++) {
            list.add(i);
        }

        System.out.println("模拟 ArrayList 最终元素个数: " + list.size());
        System.out.println("模拟 ArrayList 最终容量: " + list.capacity());
        System.out.println("模拟 ArrayList 内容: " + list);
    }

    /**
     * 简化版 ArrayList，只保留和扩容有关的核心逻辑，便于观察容量变化。
     */
    private static class SimpleArrayList {
        private static final int DEFAULT_CAPACITY = 10;
        private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

        private Object[] elementData = new Object[0];
        private int size;

        public boolean add(Object element) {
            ensureCapacity(size + 1);
            elementData[size++] = element;
            return true;
        }

        public int size() {
            return size;
        }

        public int capacity() {
            return elementData.length;
        }

        private void ensureCapacity(int minCapacity) {
            if (elementData.length == 0) {
                minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
            }

            if (minCapacity > elementData.length) {
                grow(minCapacity);
            }
        }

        private void grow(int minCapacity) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);

            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }

            if (newCapacity > MAX_ARRAY_SIZE) {
                newCapacity = hugeCapacity(minCapacity);
            }

            elementData = Arrays.copyOf(elementData, newCapacity);
            System.out.println("扩容: " + oldCapacity + " -> " + newCapacity);
        }

        private int hugeCapacity(int minCapacity) {
            if (minCapacity < 0) {
                throw new OutOfMemoryError();
            }
            return minCapacity > MAX_ARRAY_SIZE ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOf(elementData, size));
        }
    }
}
