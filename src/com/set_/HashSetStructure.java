package com.set_;

public class HashSetStructure {
    public static void main(String[] args) {
        // 模拟 HashSet 的底层结构。
        // HashSet 底层实际使用的是 HashMap；
        // 而 HashMap 在这里可以先理解为：Node[] 数组 + 单向链表。

        // 1. 创建一个 Node 类型的数组，长度是 16。
        // 每个位置都叫一个“桶（bucket）”，初始值全是 null。
        Node[] table = new Node[16];

        // 注意：直接打印数组，只会看到数组的类型和地址信息，
        // 不会把数组里每个 Node 的内容自动打印出来。
        System.out.println("table = " + table);

        // 2. 创建第一个节点，item 保存数据 "john"，
        // next 暂时是 null，表示 john 后面还没有节点。
        Node john = new Node("john", null);

        // 3. 把 john 放到数组下标为 2 的桶中。
        // 真实 HashMap 中，下标通常是根据 key 的 hash 值计算得到的；
        // 这里为了演示，直接指定 table[2]。
        table[2] = john;

        // 4. 创建第二个节点 jack。
        Node jack = new Node("jack", null);

        // 让 john 的 next 指向 jack。
        // 此时 table[2] 这条链是：
        // john -> jack -> nuwswwwwwwwwwwwwsll
        john.next = jack;

        // 5. 创建第三个节点 Rose。
        Node rose = new Node("Rose", null);

        // 让 jack 的 next 指向 Rose。
        // 此时 table[2] 这条链变成：
        // john -> jack -> Rose -> null
        jack.next = rose;

        System.out.println("table = " + table);
    }
}

// Node 就是链表中的“节点”
class Node {
    // 当前节点真正保存的数据
    Object item;

    // 指向下一个节点；若为 null，说明当前节点是最后一个
    Node next;

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }
}
