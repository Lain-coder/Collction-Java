# Collction-Java

Java 集合学习代码和笔记仓库。

## Notes

| 主题 | 笔记 | 配套代码 |
| --- | --- | --- |
| ArrayList 扩容机制 | [arraylist-growth.md](docs/arraylist-growth.md) | [ArrayListSource.java](src/com/list/ArrayListSource.java) |
| HashSet 源码学习 | [hashset-source.md](docs/hashset-source.md) | [HashSetSource.java](src/com/set_/HashSetSource.java) |

更多笔记入口：[docs/README.md](docs/README.md)

## Source Structure

```text
src/com/collection_/   Collection 基础示例
src/com/list/          List 和 ArrayList 示例
src/com/set_/          Set 和 HashSet 示例
docs/                  学习笔记
docs/assets/           笔记图片资源
```

## Naming Style

- Java 类文件使用 `PascalCase`，例如 `ArrayListSource.java`。
- 文档文件使用小写短横线命名，例如 `arraylist-growth.md`。
- 图片资源使用小写短横线命名，例如 `arraylist-growth-overview.png`。

已有源码文件名保持原样，避免影响 Java 类名、包名和学习记录。
