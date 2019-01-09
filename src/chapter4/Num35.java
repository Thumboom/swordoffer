package chapter4;

import java.util.HashMap;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}


/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 */
public class Num35 {


    /**
     * 我的思路：复杂链表复杂在其结点中有一条指针乱指，如果采用每个结点都
     * 遍历一次链表才能找到特殊指针指向的结点的话效率太低。考虑使用hasmap
     * 存储每个结点，这样可以避免重复生成同一结点的问题。
     */
    public RandomListNode my_Clone(RandomListNode pHead)
    {


        if(pHead == null) return null;
        HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
        int val;
        RandomListNode newHead = new RandomListNode(pHead.label);
        RandomListNode temp = newHead;
        map.put(pHead.label, newHead);

        while(pHead != null) {

            if(pHead.next != null) {
                val = pHead.next.label;
                if(!map.containsKey(val)) {
                    RandomListNode node = new RandomListNode(val);
                    map.put(val, node);
                }
                temp.next = map.get(val);
            }
            if(pHead.random != null) {
                val = pHead.random.label;

                if(!map.containsKey(val)) {
                    RandomListNode node = new RandomListNode(val);
                    map.put(val, node);
                }
                temp.random = map.get(val);
            }
            pHead = pHead.next;
            temp = temp.next;
        }
        return newHead;
    }

    /**
     *牛客网高分解法：首先先在原链表中的每个结点后面加入与该结点值相同的新结点，
     * 第二步是遍历旧结点， 新结点的特殊指针指向正确位置；
     * 第三步是拆分新旧链表。
     */
    public RandomListNode Clone(RandomListNode pHead) {
        //第一步，添加新结点
        if(pHead == null) return null;
        RandomListNode next = null;
        RandomListNode cur = pHead;
        RandomListNode newNext = null;
        RandomListNode newCur = null;
        RandomListNode newHead = null;
        while( cur != null) {
            next = cur.next;
            RandomListNode node = new RandomListNode(cur.label);
            cur.next = node;
            node.next = next;
            cur = next;

        }

        //第二步，新结点特殊指针指向正确位置

        cur = pHead;
        while( cur != null) {
            next = cur.next.next;
            cur.next.random = cur.random == null? null : cur.random.next;
            cur = next;
        }

        //第三步，拆分新旧链表
        cur = pHead;
        newCur= pHead.next;
        newHead = newCur;
        while( cur != null){
            next = newCur.next;
            if( next != null)
                newNext = next.next;
            else
                newNext = null;
            cur.next = next;
            newCur.next = newNext;
            cur = next;
            newCur = newNext;
        }


        return newHead;
    }




}
