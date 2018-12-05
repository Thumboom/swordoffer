package chapter3;

/**
 * ���������������������������������ϳɺ������
 * ��Ȼ������Ҫ�ϳɺ���������㵥����������
 */
public class Num25 {


    //�ҵķ���������������֮���໥��ת��������һ��ֵ��Ľڵ�Ϊ�ο���ֱ��С�Ľڵ������Ͱ�ǰһ���ڵ�ָ��֮ǰֵ��Ľڵ�
    public ListNode a_Merge(ListNode list1,ListNode list2) {
        ListNode small,big,afterMerge;
        ListNode s_pre = null;
        if( list1 == null && list2 == null) return null;
        else if( list1 == null) return list2;
        else if( list2 == null) return list1;
        //ѡ��ĺ�С��ֵ�Ľڵ�
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
            //����ֱ��С�Ľڵ�ȴ�Ľڵ��ֵ����
            while( small != null && small.val <= big.val ){
                s_pre = small;
                small = small.next;
            }

            s_pre.next = big;
            //��������ı�С�ģ�С�ı���
            if( small != null) {
                big = small;
                small = s_pre.next;
            }

        }
        return afterMerge;
    }


    /**
     * �Ϻõķ������½�һ��ͷ�ڵ㣬������������ȡ���������С�Ľڵ㹹��������
     *
     */
    public ListNode b_Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode root = head;

        while(list1 != null && list2 != null){
            //ѡȡС����Ϊ��������һ���ڵ�
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
        //ʣ�µ�����ֱ�ӽ���ȥ
        if(list1 != null ) head.next = list1;
        if(list2 != null) head.next = list2;

        return root.next;

    }


    /**
     * �ݹ�汾
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
