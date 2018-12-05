package chapter3;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 */
public class Num25 {


    //我的方法：在两个链表之间相互跳转，以其中一个值大的节点为参考，直至小的节点比它大就把前一个节点指向之前值大的节点
    public ListNode a_Merge(ListNode list1,ListNode list2) {
        ListNode small,big,afterMerge;
        ListNode s_pre = null;
        if( list1 == null && list2 == null) return null;
        else if( list1 == null) return list2;
        else if( list2 == null) return list1;
        //选大的和小的值的节点
        if(list1.val > list2.val) {
            big = list1;
            small = list2;
        } else {
            big = list2;
            small = list1;
        }
        afterMerge = small;
        s_pre = small;
        while( big != null && small != null) {
            //遍历直至小的节点比大的节点的值还大
            while( small != null && small.val <= big.val ){
                s_pre = small;
                small = small.next;
            }

            s_pre.next = big;
            //交换，大的变小的，小的变大的
            if( small != null) {
                big = small;
                small = s_pre.next;
            }

        }
        return afterMerge;
    }


    /**
     * 较好的方法：新建一个头节点，遍历两条链表，取两条链表间小的节点构成新链表
     *
     */
    public ListNode b_Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode root = head;

        while(list1 != null && list2 != null){
            //选取小的作为新链表下一个节点
            if(list1.val <= list2.val){
                head.next = list1;
                head = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                head = list2;
                list2 = list2.next;
            }
        }
        //剩下的链表直接接上去
        if(list1 != null ) head.next = list1;
        if(list2 != null) head.next = list2;

        return root.next;

    }


    /**
     * 递归版本
     *
     * */
    public ListNode c_Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = c_Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = c_Merge(list1, list2.next);
            return list2;
        }
    }
}
