package chapter4;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左
 * 到右的顺序打印，第二层按照从右至左的顺序打印，第三行
 * 按照从左到右的顺序打印，其他行以此类推。
 */
public class Num32_3 {


    /**
     * 我的思路：用两个栈来按所要求的顺序的逆序来保存每层结点。
     * 一个用来遍历，另一用来保存子树，遍历完后再交换一下指针，
     * 重新开始新一轮的遍历。
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        Stack<TreeNode> s3;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        boolean left = true;
        s1.push(pRoot);
        TreeNode temp = null;
        //两个栈都为空才结束
        while( !s1.isEmpty() && !s2.isEmpty()){
            ArrayList<Integer> list = new ArrayList<Integer>();

            while( !s1.isEmpty()){
                temp = (TreeNode)s1.pop();
                list.add(temp.val);
                //按所要求的次序的逆序将下一层结点加入栈中
                if( left){
                    if( temp.left != null)
                        s2.push(temp.left);
                    if( temp.right != null)
                        s2.push(temp.right);
                } else {
                    if( temp.right != null)
                        s2.push(temp.right);
                    if( temp.left != null)
                        s2.push(temp.left);
                }
            }
            res.add(list);
            left = left? false : true;
            s3 = s1;
            s1 = s2;//交换指针
            s2 = s3;
        }
        return res;
    }
}
