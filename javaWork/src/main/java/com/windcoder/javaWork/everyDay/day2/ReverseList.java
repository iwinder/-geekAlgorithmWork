package com.windcoder.javaWork.everyDay.day2;

public class ReverseList {
    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // last 指向 当前 节点，即作为新的头节点
       ListNode last = null;
       while(head!=null) {
           // nextHead 用于保存当前指针的next节点
           ListNode nextHead = head.next;
           // 当前节点的 next 指向 last 节点
           head.next = last;
           // last节点更新为 当前节点
           last = head;
           // 当前节点向后移动
           head= nextHead;
       }
       return last;
    }

    /**
     * 递归实现
     * @param head
     * @return
     */
    public ListNode reverseListByRecursion(ListNode head) {
        ListNode cur = head;
        ListNode last = null;

        return recursion(cur,last);
    }

    public ListNode recursion( ListNode cur, ListNode last) {
        if (cur == null) {
            return last;
        } else {
            ListNode nextHead = cur.next;
            cur.next = last;
            last = cur;
            cur = nextHead;
            return recursion(cur,last);
        }
    }
}


class ListNode {
     int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}