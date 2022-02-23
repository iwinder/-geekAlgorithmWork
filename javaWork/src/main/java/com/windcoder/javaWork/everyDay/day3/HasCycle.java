package com.windcoder.javaWork.everyDay.day3;


import com.windcoder.javaWork.common.ListNode;

/**
 * 141. 环形链表 https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * 快慢指针法 O(length)时间，O(1)空间
 *
 * 有环比定发生套圈（快慢指针相遇），无环不会发生相遇（快指针到达null）
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode cur = head,fast = head;
        while (fast!=null&&fast.next!=null) {
            fast = fast.next.next;
            cur = cur.next;
            if (fast==cur) {
                return true;
            }
        }
        return false;
    }
}
