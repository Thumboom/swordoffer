package chapter6;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树.
 * 注意，这里的平衡二叉树的定义是左右子树的高度差
 * 是否不超过一，而不是一定要是排序二叉树。
 */
public class Num55_2 {
    public int flag = 0;

    /**
     * 牛客思路：后续遍历找出每个结点的子树的差，若超过一，则不平衡，
     * 这里还设了一个flag变量来剪枝。
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return cheat(root) >= 0;
    }

    public int cheat(TreeNode root){
        if( flag == -1) return -1;//已经不平衡，没有不需要在遍历，剪枝
        if( root == null) return 0;

        int left = cheat(root.left);
        int right = cheat(root.right);

        flag = (left >= 0 && right >= 0 && Math.abs(left- right) <=1)?
                Math.max(left, right) + 1: -1;
        return flag;

    }

}
