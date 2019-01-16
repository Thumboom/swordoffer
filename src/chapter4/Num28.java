package chapter4;
/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Num28 {

    /**
     * 我的思路：一棵树对称意味着这棵树的在先序遍历中，无论是先遍历左子树还是
     * 先遍历右子树，其产生的序列都是一样的。因此，可以用一个递归函数递归比较
     * 先遍历左孩子和先遍历右孩子这两种方式产生的序列。
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot)
    {

        return help(pRoot, pRoot);
    }


    boolean help(TreeNode pLeft, TreeNode pRight){
        if( pLeft == null && pRight == null)
            return true;
        else if( pLeft == null || pRight == null){
            return false;
        }

        if( pLeft.val != pRight.val){
            return false;
        }

        boolean a = help(pLeft.left, pRight.right);
        //剪枝
        if(!a) return false;

        boolean b = help(pLeft.right, pRight.left);
        return a && b;
    }
}
