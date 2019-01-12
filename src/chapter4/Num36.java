package chapter4;

public class Num36 {

    /**
     * 我的思路，二叉查找树数是有序的，一个结点一定比它的左子树要大，比它的右子树要小
     * 把二叉查找树变成变成∧这种形状然后在改成双向指针的形式。
     * 1. 如果一个结点的左子树有右子树，找到其右子树的最小的结点，将原本的那个结点指向该最小结点
     *    并将该最小结点的左指针指向原来结点的左子树
     * 2. 如果一个结点的右子树有左子树，找到其左子树的最大结点， 将原本的那个结点指向该最大结点
     *    并将该最大结点的右指针子树指向原来结点的左子树
     * 3. 如果该结点不存在上述两种情况，递归排序其左右子树。
     *
     * 4. 等到全部排序完毕，适当改变指针变成双向链表
     *
     */


        public TreeNode my_Convert(TreeNode pRootOfTree) {
            if(pRootOfTree == null) return null;
            adjustTree(pRootOfTree);
            transDuList(pRootOfTree);

            return min(pRootOfTree);
        }

        public void transDuList(TreeNode root){
            //调整左边
            TreeNode cur = root;
            while( cur.left != null){
                cur.left.right = cur;
                cur = cur.left;
            }

            //调整右边
            cur = root;
            while( cur.right != null){
                cur.right.left = cur;
                cur = cur.right;
            }

        }

        public void adjustTree(TreeNode root){
            TreeNode temp = null;
            if(root == null) return;
            if( root.left != null) {
                //左子树根节点有右子树
                while( root.left.right != null) {
                    temp = min(root.left.right);
                    temp.left = root.left;
                    root.left = root.left.right;
                    temp.left.right = null;
                }

            }

            if( root.right != null) {
                //左子树根节点有右子树
                while( root.right.left != null){
                    temp = max(root.right.left);
                    temp.right = root.right;
                    root.right = root.right.left;
                    temp.right.left = null;
                }
            }

            adjustTree(root.left);
            adjustTree(root.right);

        }

        public TreeNode min(TreeNode node){
            if(node.left == null) return node;
            return min(node.left);
        }

        public TreeNode max(TreeNode node){
            if(node.right == null) return node;
            return max(node.right);
        }

    /**
     * 牛客好的解法： 中序遍历
     *
     *
     */

    TreeNode head = null;
    TreeNode realHead = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    private void ConvertSub(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return;
        ConvertSub(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }

}
