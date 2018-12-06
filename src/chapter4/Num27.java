package chapter4;


/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 */
public class Num27 {

    public void Mirror(TreeNode root) {
        if(root == null)
            return;

        Mirror(root.right);
        Mirror(root.left);
        TreeNode node = root.right;
        root.right = root.left;
        root.left = node;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
