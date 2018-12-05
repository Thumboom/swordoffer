package chapter3;

/**
 * ����һ����������������е�����k�����
 */
public class Num22 {
    //�ҵĽⷨ�����õݹ�ջ�����ԴӺ���ǰ��
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
     * �õĽⷨ����������ָ��p1��p2��p1��p2����k-1�����
     * ��p1Ϊnullʱ��p2���ǵ�����k�����
     */
    public ListNode b_FindKthToTail(ListNode head,int k) {
        ListNode p1,p2;
        p1 = head;
        p2 = head;

        while(p1 != null){
            //��p1��p2����k-1��λ
            if( k > 0) {
                p1 = p1.next;
                --k;
                continue;//
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        if(k > 0) return null;//������k���������������ȣ����ؿ�ָ��
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
