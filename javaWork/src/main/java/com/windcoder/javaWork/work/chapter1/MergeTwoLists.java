package com.windcoder.javaWork.work.chapter1;

import com.windcoder.javaWork.common.ListNode;

/**
 * [21. 合并两个有序链表]( https://leetcode-cn.com/problems/merge-two-sorted-lists/)
 *
 *
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 创建新链表的头结点  curHead 以及用于执行链接两个链表的 初始节点 cur
        ListNode curHead = new ListNode(0),cur = curHead;
        // 其中一个链表为空即可结束循环
        while(list1!=null&&list2!=null) {
            // 当list1的值大于list2时，cur取list2，反之取list1
            if(list1.val>=list2.val) {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            } else {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }
        }
        // 其中一个为空后，将另一个列表的剩余部分直接追加即可，无需在进行多次循环。
        cur.next = list1!=null? list1:list2;
        return curHead.next;
    }

    public ListNode mergeTwoListsByRecursion(ListNode list1, ListNode list2) {
        ListNode curHead = new ListNode(0),cur = curHead;
        recursion( list1,  list2, cur);
        return curHead;
    }

    public ListNode recursion(ListNode list1, ListNode list2,ListNode cur) {
        if(list1==null) {
            cur.next = list2;
            return cur;
        } else if(list2==null) {
            cur.next = list1;
            return cur;
        }if(list1.val>=list2.val) {
            cur.next = list2;
            cur = cur.next;
            list2 = list2.next;
        } else {
            cur.next = list1;
            cur = cur.next;
            list1 = list1.next;
        }
        return recursion(list1,list2,cur);
    }

}
