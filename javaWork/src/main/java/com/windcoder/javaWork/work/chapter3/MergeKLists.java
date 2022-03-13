package com.windcoder.javaWork.work.chapter3;

import com.windcoder.javaWork.common.ListNode;

/**
 * [23. 合并K个升序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)
 */
public class MergeKLists {


    /**
     * 方案一：依次合并两个数组
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode result = null;
        for (int i=0;i<lists.length;i++) {
            result = mergeTwoLists(result,lists[i]);
        }
        return result;
    }


    /**
     * 方案二：分治合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }

    /**
     * 成对合并。每完成一轮,便会合并成原长度的一半
     * @param lists
     * @param l
     * @param r
     * @return
     */
    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l==r) {
            return lists[l];
        }
        if (l>r) {
            return null;
        }
        int mid = (l+r)/2;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    /**
     * 比较两个列表
     * @param a
     * @param b
     * @return
     */
    public ListNode mergeTwoLists(ListNode a,ListNode b) {
        if (a==null|| b==null) {
            return a!=null?a:b;
        }
        ListNode head = new ListNode(0);
        ListNode cur = head,aPtr = a,bPtr = b;
        while(aPtr!=null&&bPtr!=null) {
            if (aPtr.val<bPtr.val) {
                cur.next = aPtr;
                aPtr = aPtr.next;
            } else {
                cur.next = bPtr;
                bPtr = bPtr.next;
            }
            cur = cur.next;
        }
        cur.next = (aPtr!=null?aPtr:bPtr);
        return head.next;
    }
}
