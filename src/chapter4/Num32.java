package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 */
public class Num32 {

    /**
     * 思路：二叉树其实可以用数组表示，本题其实考的就是这一个知识，
     * 这里借助了队列去代替数组，比较省事
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
