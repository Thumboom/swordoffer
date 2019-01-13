package chapter6;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}


/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点
 * （含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 */
public class Num55 {
    int longest = 0;

    /**
     * 我的思路：简单递归，设置一个成员变量值保留最深层次
     *
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        depth(root, 0);
        return longest;
    }

    public void depth(TreeNode root, int depth){
        if( root == null)
            return;
        depth++;
        longest = longest<depth? depth : longest;

        depth(root.left, depth);
        depth(root.right, depth);
    }

}
