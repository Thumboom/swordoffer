package chapter3;

/**
 * 输入一个链表，输出该链表中倒数第k个结点
 */
public class Num22 {
    //我的解法：利用递归栈的特性从后往前数
    public ListNode node = null;
    public ListNode a_FindKthToTail(ListNode head,int k) {
        find(head, k);
        return node;
    }

    public int find(ListNode head, int k){
        if( head == null) return 0;
        int temp = find(head.next , k) + 1;

        if(temp == k) {
            node = head;
        }
        return temp;
    }

    /**
     * 好的解法：设置两个指针p1和p2，p1比p2领先k-1个结点
     * 当p1为null时，p2就是倒数第k个结点
     */
    public ListNode b_FindKthToTail(ListNode head,int k) {
        ListNode p1,p2;
        p1 = head;
        p2 = head;

        while(p1 != null){
            //让p1比p2领先k-1个位
            if( k > 0) {
                p1 = p1.next;
                --k;
                continue;//
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        if(k > 0) return null;//倒数第k个数超过了链表长度，返回空指针
        return p2;
    }

}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }


    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
