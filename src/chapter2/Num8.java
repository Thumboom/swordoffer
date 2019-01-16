package chapter2;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序
 * 的下一个结点并且返回。注意，树中的结点不仅包含左右
 * 子结点，同时包含指向父结点的指针。
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Num8 {

    /**
     * 思路：中序遍历的特征是“左中右”设当前结点为中，下一结点就是右子树，又重复
     * “左中右”的过程，所以，当前结点的下一结点的就是右子树中最左的结点。
     * 如果当前结点没有右子树，那么就代表当前树都被遍历过了，
     * 那么按照中序遍历的特点，也就是某个结点的左子树都被遍历完毕，下一结点就是
     * 某个结点，所以向上搜寻，直到当前结点是某个结点的左子树，那么这个某个结点就是
     * 要求得结点。
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode res = null;
        if(pNode == null ) return null;

        if( pNode.right != null){
            //找到右子树中，最左的结点
            res = getLeftest(pNode.right);
        } else {
            //否则，向上找到当前数作为左子树的父母结点
            res = pNode.next;
            while( res != null && res.left != pNode){
                pNode = res;
                res = res.next;
            }
        }
        return res;
    }

    public TreeLinkNode getLeftest(TreeLinkNode cur){
        while( cur.left != null){
            cur = cur.left;
        }
        return cur;
    }

}
