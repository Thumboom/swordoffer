package chapter3;


/**
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ��
 * ��ps������Լ��������������һ�������ӽṹ��
 */

public class Num26 {


    /**
     * �ҵ�˼·�����ҵ��������ӽṹ���ڵ���ֵͬ�Ľڵ㣬�ٱ�������������
     * ��������У������һ�������ڵ������ڵ㲻��ȣ��ͷ���false��
     * �ټ���Ѱ���������ӽṹ���ڵ���ֵͬ�Ľڵ�...���ѭ����ȥ��ֱ��
     * ��Ϊ�ա�
     *
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        boolean isSubtree1 = false;
        boolean isSubtree2 = false;
        boolean isSubtree3 = false;
        if( root1.val != root2.val) {
            isSubtree1 = HasSubtree(root1.left, root2);//��������ȥѰ�����ӽṹ��ֵͬ�Ľڵ�
            isSubtree2 = HasSubtree(root1.right, root2);
            return isSubtree1 || isSubtree2;
        } else {
            isSubtree3 = isSubtree(root1, root2); //�����ӽṹ
            //��������㣬����Ѱ�����ӽṹ��ֵͬ�Ľڵ�

            if(!isSubtree3)
                isSubtree3 = HasSubtree(root1.left, root2);
            if(!isSubtree3)
                isSubtree3 = HasSubtree(root1.right, root2);
            return isSubtree3;
        }


    }

    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        if( root1 == null && root2 == null) return true;
        if( root1 == null && root2 != null) return false;
        if( root1 != null && root2 == null) return true;
        if(root1.val != root2.val ) return false;
        return isSubtree(root1.left, root2.left) &&
                isSubtree(root1.right, root2.right);
    }
}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(7);

        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);

        TreeNode node7 = new TreeNode(7);

        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        node5.left = node6;
        node5.right = node7;

        node8.left = node9;
        node8.right = node10;

        Num26 s = new Num26();

        System.out.println(s.HasSubtree(node1, node8));

    }

}
