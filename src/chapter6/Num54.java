package chapter6;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结
 * 点数值大小顺序第三小结点的值为4。
 */
public class Num54 {
    public int order = 0;

    /**
     * 我的思路：简单，就中序遍历。
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        return help(pRoot, k);
    }

    TreeNode help(TreeNode pRoot, int k ){
        if( pRoot == null) return null;
        TreeNode pLeft = help(pRoot.left, k);
        if( pLeft != null) return pLeft;
        order ++;
        if( order == k) return pRoot;
        TreeNode pRight = help(pRoot.right, k);
        return pRight;

    }

}
