package chapter4;
import java.util.ArrayList;

public class Num34 {
    public ArrayList<ArrayList<Integer>> allList = new ArrayList<ArrayList<Integer>>();
    public ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

        findPath(root, target);
        return allList;
    }
    //这题用到回溯思想
    public void findPath(TreeNode root, int target){
        if(target < 0 || root == null) return;
        int newTarget = target - root.val;

        list.add(root.val);
        if( newTarget == 0 &&
                (root.right == null || root.left == null)) {
            //一定new一个新链表出来
            allList.add(new ArrayList<Integer>(list));
        }

        findPath(root.left, newTarget);
        findPath(root.right, newTarget);
        list.remove(list.size() - 1);


    }


}
