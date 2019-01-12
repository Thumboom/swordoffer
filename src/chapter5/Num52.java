package chapter5;

import java.util.HashSet;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Num52 {

    //我的思路：先将一个链表的所有节点加入到
    public ListNode my_FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<ListNode>();

        ListNode node = pHead1;
        while(node != null){
            set.add(node);
            node = node.next;
        }
        node = pHead2;
        while( node != null){
            if( !set.add(node)){
                return node;
            }
            node = node.next;
        }

        return null;
    }

    /**
     * 牛客好的思路：
     * 假定 List1长度: a+n  List2 长度:b+n, 且 a小于b那么 p1 会先到链表尾部,
     *             这时p2 走到 a+n位置,将p1换成List2头部接着p2 再走b+n-(n+a) =b-a 步到链
     *             表尾部,这时p1也走到List2的b-a位置，还差a步就到可能的第一个公共节点。
     *             将p2 换成 List1头部，p2走a步也到可能的第一个公共节点。如果恰好p1==p2,
     *             那么p1就是第一个公共节点。或者p1和p2一起走n步到达列表尾部，二者没有公共
     *             节点，退出循环。 同理a>=b.
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode p1 = pHead1, p2 = pHead2;

        while( p1 != p2){
            p1 = (p1 != null) ? p1.next : pHead2;
            p2 = (p2 != null) ? p2.next : pHead1;
        }

        return p1;
    }

}
