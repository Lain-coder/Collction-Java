package com.set_;

import java.util.HashSet;

@SuppressWarnings({"all"})
public class HashSetSource {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();

        hashSet.add("java");
        hashSet.add("php");
        hashSet.add("java"); // 重复添加，添加失败

        System.out.println("hashSet = " + hashSet);
    }

    /*
    1. 调用 HashSet 构造器

    public HashSet() {
        map = new HashMap<>();
    }
    */

    /*
    2. 调用 add()

    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    e = "java"
    将要添加的元素作为 HashMap 的 key；
    value 是固定对象 PRESENT。
    */

    /*
    3. 调用 HashMap 的 put()

    public V put(K key, V value) {
        // key = "java"，value = PRESENT
        // 调用 hash(key)，获取 key 对应的 hash 值
        return putVal(hash(key), key, value, false, true);
    }
    */

    /*
    hash(key)：

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    得到的 hash 用于计算 key 在 table 数组中的索引位置。
    */

    /*
    4. 执行 putVal()
    */
    /*
    final V putVal(int hash, K key, V value,
                   boolean onlyIfAbsent, boolean evict) {

        Node<K,V>[] tab;
        Node<K,V> p;
        int n, i;

        // table 是 HashMap 的一个数组，类型是 Node[]
        // 如果当前 table 为 null，或者大小为 0，
        // 表示第一次扩容，到 16 个空间
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;

        // (1) 根据 key 得到 hash，计算该 key 应该存放到
        //     table 表中的哪个索引位置
        // (2) 将该位置的对象赋给 p
        // (3) 判断 p 是否为 null
        // (3.1) 如果 p 为 null，表示该位置还没有存放元素，
        //       就创建一个 Node(key = "java", value = PRESENT)
        // (3.2) 放到 tab[i] 位置
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);

        else {
            Node<K,V> e;
            K k;

            // 如果当前桶的第一个节点与要添加的 key 相同，
            // 说明 key 已经存在
            if (p.hash == hash &&
                ((k = p.key) == key ||
                (key != null && key.equals(k))))
                e = p;

            // 如果当前桶是红黑树，按照红黑树方式添加
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(
                    this, tab, hash, key, value);

            // 否则，当前桶是链表，按链表方式添加
            else {
                for (int binCount = 0; ; ++binCount) {

                    // 遍历到链表尾部，说明没有重复元素
                    if ((e = p.next) == null) {
                        // 将新节点挂在链表末尾
                        p.next = newNode(hash, key, value, null);

                        // 链表节点达到一定数量时，尝试树化
                        if (binCount >= TREEIFY_THRESHOLD - 1)
                            treeifyBin(tab, hash);
                        break;
                    }

                    // 链表中找到相同的 key
                    if (e.hash == hash &&
                        ((k = e.key) == key ||
                        (key != null && key.equals(k))))
                        break;

                    // p 后移，继续比较下一个节点
                    p = e;
                }
            }

            // e 不为 null，表示 key 已存在
            if (e != null) {
                V oldValue = e.value;

                // HashSet 的 value 都是 PRESENT；
                // 因为 key 已存在，所以不会新增元素
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;

                afterNodeAccess(e);
                return oldValue;
            }
        }

        // 新增节点后，修改次数加 1
        ++modCount;

        // 元素数量超过阈值，进行扩容
        if (++size > threshold)
            resize();

        afterNodeInsertion(evict);
        return null;
    }
    */
}
