package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Num32_2 {

    /**
     * 我的思路：由于是从上到下，从左到右，所以只需要用一个队列保存即可。
     * 每次先将左结点放进队列，再将右结点放入队列。设置两个变量来记录
     * 每层结点的个数。
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res =
                                new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();

        int num = 0;
        int subNum = 0;
        if( pRoot != null){
            q.add(pRoot);
            num ++;
        }
        TreeNode temp = null;
        ArrayList<Integer> list = new ArrayList<Integer>();

        while( !q.isEmpty() ){
            temp =  q.pollFirst();
            num --;
            list.add(temp.val);
            if( temp.left != null){
                q.add(temp.left);
                subNum++;
            }
            if( temp.right != null){
                q.add(temp.right);
                subNum ++;
            }
            if( num == 0 ){
                num = subNum;
                subNum = 0;
                res.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return res;
    }
}
