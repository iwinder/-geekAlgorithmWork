## 第一周作业

- [加一（Easy）](PlusOne.java)
  - 倒序遍历数组，逐位+1。
  - 加一后取模，不是0即可返回。
  - 存在类似99的临界点，此时循环结束，数组中全是0，需要在最低位插入一位，其值为1
- [合并两个有序链表（Easy）](MergeTwoLists.java)
  - 创建新链表的头结点  curHead 以及用于执行链接两个链表的 初始节点 cur
  - 循环结束条件：其中一个链表为空即可结束循环
  - 当list1的值大于list2时，cur取list2，反之取list1
  - 其中一个为空后，将另一个列表的剩余部分直接追加即可，无需在进行多次循环。
- [设计循环双端队列（Medium）](MyCircularDeque.java)
  - 可通过链表或数组实现，当前优先选了链表方式
- [最大矩形（Hard）](MaximalRectangle.java)
   