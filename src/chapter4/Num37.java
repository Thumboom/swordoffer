package chapter4;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Num37 {
    StringBuilder sb = new StringBuilder();
    int index = -1;
    String Serialize(TreeNode root) {
        pre(root);
        return sb.toString();
    }
    void pre( TreeNode root){
        if( root == null){
            sb.append("#!");
            return;
        }

        sb.append(root.val + "!");
        pre(root.left);
        pre(root.right);
    }

    /**
     *  算法思想：根据前序遍历规则完成序列化与反序列化。所谓序列化指的是遍历二叉树为字符串；
     *  所谓反序列化指的是依据字符串重新构造成二叉树。
     *     依据前序遍历序列来序列化二叉树，因为前序遍历序列是从根结点开始的。当在遍历二叉树
     *     时碰到Null指针时，这些Null指针被序列化为一个特殊的字符“#”。
     *     另外，结点之间的数值用"!"隔开。
     * @param str
     * @return
     */
    TreeNode Deserialize(String str) {
        String[] ss = str.split("!");

        return makeTree(ss);
    }
    TreeNode makeTree(  String[] ss){
        index ++;
        if( index >= ss.length || ss[index].equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.valueOf(ss[index]));
        root.left = makeTree(ss);
        root.right = makeTree(ss);
        return root;
    }

}
