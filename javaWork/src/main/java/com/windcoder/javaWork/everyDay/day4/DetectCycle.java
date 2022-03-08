package com.windcoder.javaWork.everyDay.day4;

import com.windcoder.javaWork.common.ListNode;

/**
 * [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head,cur = head;
        // 1. 若fast 快指针走到末端，说明没有环。只要有环，快慢指针一定相遇。
        // 2. 假设一个环形链表 由 a+b两部分组成，a为环之前的步长，b为一个环长。
        // 3. f = 2c 快指针走的是慢指针的2倍
        // 4. f = c+nb 相遇时快指针比慢指针多走n个环长，即环长的整数倍。
        // 5. 2c = c+nb => c=nb
        // 6. 从head结点走到入环点需要走 ： a + nb(从head到入口a步，之后每绕一圈nb)
        // 7. 由 5 我们知道 慢指针c此时已经走了nb步，所以只需走a步就能到达入口点。
        // 8. 此时将快指针重新指向 head,变成一次走一步,和慢指针一起走 a 步，两者便可在入口处相遇，此时fast就是入口节点。
        while (fast!=null&&fast.next!=null) {
            fast = fast.next.next;
            cur = cur.next;
            if (fast==cur) {
                fast = head;
                while (fast!=cur) {
                    fast = fast.next;
                    cur = cur.next;
                }
                break;
            }
        }

        if (fast==null||fast.next==null) {
            return null;
        }
        return fast;
    }

    // s 3 2 0 4 2 0 4 2 0 4
    // f 3 0 2 4 0 2 4 0 2 4
    //  f = 2s
    // f = a+nk
    // s = a +k
}
