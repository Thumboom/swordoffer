package chapter2;

import java.util.HashMap;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Num23 {

    /**
     * 我的思路：用hashmap保存每个链表中的结点，如果遇到重复的就必定是环的入口
     * @param pHead
     * @return
     */
    public ListNode my_EntryNodeOfLoop(ListNode pHead)
    {
        HashMap map = new HashMap();

        ListNode cur = pHead;

        boolean first = true;
        while( cur != null){
            first = map.containsKey(cur);
            if( first) return cur;

            map.put(cur, null);
            cur = cur.next;
        }

        return null;
    }

    /**
     * 假设x为环前面的路程（黑色路程），a为环入口到相遇点的路程（蓝色路程，假设顺时针走）， c为环的长度（蓝色+橙色路程）
     * 当快慢指针相遇的时候：
     *
     * 此时慢指针走的路程为Sslow = x + m * c + a
     * 快指针走的路程为Sfast = x + n * c + a
     * 2 Sslow = Sfast
     * 2 * ( x + m*c + a ) = (x + n *c + a)
     * 从而可以推导出：
     * x = (n - 2 * m )*c - a
     * = (n - 2 *m -1 )*c + c - a
     * 即环前面的路程 = 数个环的长度（为可能为0） + c - a
     * 什么是c - a？这是相遇点后，环后面部分的路程。（橙色路程）
     * 所以，我们可以让一个指针从起点A开始走，让一个指针从相遇点B开始继续往后走，
     * 2个指针速度一样，那么，当从原点的指针走到环入口点的时候（此时刚好走了x）
     * 从相遇点开始走的那个指针也一定刚好到达环入口点。
     * 所以2者会相遇，且恰好相遇在环的入口点。
     *
     * 最后，判断是否有环，且找环的算法复杂度为：
     *
     * 时间复杂度：O(n)
     *
     * 空间复杂度：O(1)
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if( pHead.next == null || pHead.next.next == null)
            return null;

        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;

        while( fast != slow){
            if( fast.next == null || fast.next.next == null)
                return null;

            fast = fast.next.next;
            slow = slow.next;
        }

        fast = pHead;

        while( fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

}
