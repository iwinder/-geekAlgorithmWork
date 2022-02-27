package com.windcoder.javaWork.everyDay.day6;

import com.windcoder.javaWork.common.ListNode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode(0,head);
        ListNode last = pre;
        while (head!=null) {
            // 分组，每k个一组
            ListNode end = getEndNode(head,k);
            if (end==null) break;
            ListNode netGHead = end.next;
            reverseList(head,netGHead);
            last.next=end;
            head.next = netGHead;
            last = head;
            head = netGHead;
        }
        return pre.next;
    }

    private ListNode getEndNode(ListNode head, int k) {
        while (head!=null) {
            k--;
            if (k==0) return head;
            head=head.next;
        }
        return null;
    }
    public void reverseList(ListNode head,ListNode stop) {
        // last 指向 当前 节点，即作为新的头节点
        ListNode last = head;
        head = head.next;
        while(head!=stop) {
            // nextHead 用于保存当前指针的next节点
            ListNode nextHead = head.next;
            // 当前节点的 next 指向 last 节点
            head.next = last;
            // last节点更新为 当前节点
            last = head;
            // 当前节点向后移动
            head= nextHead;
        }
    }

}
