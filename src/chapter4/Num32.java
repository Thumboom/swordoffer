package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ
 */
public class Num32 {

    /**
     * ˼·����������ʵ�����������ʾ��������ʵ���ľ�����һ��֪ʶ��
     * ��������˶���ȥ�������飬�Ƚ�ʡ��
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        LinkedList list1 = new LinkedList<TreeNode>();
        ArrayList list2 = new ArrayList<Integer>();
        TreeNode cur;
        if(root == null) return list2;

        list1.add(root);
        while(!list1.isEmpty()){
            cur = (TreeNode) list1.getFirst();
            list2.add(cur.val);

            list1.removeFirst();
            if(cur.left != null){
                list1.add(cur.left);
            }

            if(cur.right != null){
                list1.add(cur.right);
            }
        }
        return list2;
    }
}
