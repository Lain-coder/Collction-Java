# HashSet 源码学习笔记（JDK 8）

配套代码：[src/com/set_/HashSetSource.java](../src/com/set_/HashSetSource.java)

这篇笔记配合 `HashSetSource` 阅读，重点跟随一次 `hashSet.add("java")` 的执行流程，理解 HashSet 如何去重。

## 1. HashSet 的底层结构

`HashSet` 底层使用的是 `HashMap`：

```java
public HashSet() {
    map = new HashMap<>();
}
```

因此，HashSet 并不是自己单独保存元素，而是把元素交给 HashMap 保存。

## 2. add 方法做了什么

调用：

```java
hashSet.add("java");
```

会进入：

```java
public boolean add(E e) {
    return map.put(e, PRESENT) == null;
}
```

其中：

- `e` 就是要添加的元素，例如 `"java"`。
- `e` 被作为 HashMap 的 `key`。
- `PRESENT` 是一个固定对象，被作为 HashMap 的 `value`。

可以简单理解为：

```java
map.put("java", PRESENT);
```

HashSet 能去重，是因为 HashMap 的 key 不能重复。

## 3. 调用 HashMap.put

HashMap 接着执行：

```java
public V put(K key, V value) {
    return putVal(hash(key), key, value, false, true);
}
```

本次调用中：

```text
key   = "java"
value = PRESENT
```

在进入 `putVal` 前，先调用 `hash(key)` 计算 hash 值。这个 hash 值会用于确定元素存入底层数组的哪个位置。

## 4. 第一次添加时：创建数组

```java
if ((tab = table) == null || (n = tab.length) == 0)
    n = (tab = resize()).length;
```

`table` 是 HashMap 底层的 `Node[]` 数组。第一次调用 `add` 时，`table` 还没有创建，因此会执行 `resize()`，创建默认长度为 `16` 的数组。

## 5. 计算存放位置

```java
i = (n - 1) & hash;
```

- `n` 是数组长度，第一次添加时为 `16`。
- `i` 是元素应该放入 `table` 的索引位置。
- `(n - 1) & hash` 用于根据 hash 计算数组下标。

然后取出该位置的节点：

```java
p = tab[i];
```

## 6. 桶为空：直接创建 Node

```java
if ((p = tab[i = (n - 1) & hash]) == null)
    tab[i] = newNode(hash, key, value, null);
```

如果 `p == null`，说明这个位置还没有存放元素，直接创建一个 Node：

```text
key   = "java"
value = PRESENT
next  = null
```

并把它放到 `tab[i]` 中。

## 7. 桶不为空时的三种情况

如果 `tab[i]` 已经有元素，会进入 `else`：

1. 第一个节点的 key 与当前 key 相同：表示元素已经存在。
2. 当前桶是红黑树：按照红黑树方式查找或添加。
3. 当前桶是链表：逐个比较链表中的节点。

链表遍历时：

- 找到相同 key：不再新增节点。
- 没找到相同 key，且已经到链表尾部：将新节点挂到链表末尾。
- 链表节点较多时，会尝试树化。

## 8. 为什么重复添加 java 会失败

第二次执行：

```java
hashSet.add("java");
```

由于两个 `"java"` 的 hash 相同，并且：

```java
"java".equals("java") // true
```

HashMap 能找到已存在的节点。此时 `put` 返回旧的 `value`，也就是 `PRESENT`，不是 `null`。

因此：

```java
map.put(e, PRESENT) == null
```

结果为 `false`，第二个 `"java"` 不会加入 HashSet。

## 9. 本次流程总结

```text
HashSet.add("java")
        ↓
HashMap.put("java", PRESENT)
        ↓
计算 hash(key)
        ↓
首次添加则创建长度为 16 的 Node[] 数组
        ↓
计算数组下标 i = (n - 1) & hash
        ↓
桶为空：创建 Node 并直接存入
桶不为空：判断重复、链表或红黑树
```

记忆重点：**HashSet 的元素存放在 HashMap 的 key 中，value 统一使用 PRESENT；依靠 HashMap 的 key 不重复实现去重。**
