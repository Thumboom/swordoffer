package chapter4;


/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Num33 {

    /**
     * 我的思路：二叉查找树的后序序列中，最后一个元素是树的根节点，前面的数字
     * 分为左子树和右子树，根据左子树<根<右子树，分界线的确定有两种方法，第一
     * 种是从左到右遍历序列遇到的第一个大于根节点的元素就是分界线；第二种是
     * 从根节点右边开始遍历序列，遇到的第一个小于根节点的元素就是分界线。
     * 我的想法是采用的第二种。
     * 在第二种的分界线的左边（包含分界线）是左子树，右边直至根节点前一个
     * 元素是右子树，这是判断左子树中是否有大于根节点的元素，有则返回false。
     * 再采用分治思想递归判断子树和右子树中的情况。
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return a_judge(sequence, 0, sequence.length - 1);
    }

    public boolean a_judge(int[] a, int start, int end){
        if(start >= end)
            return true;

        int i = end - 1;

        //找到第一个比根节点小的元素
        while( i >= start &&  a[i] > a[end] ){
            -- i;
        }
        //如果左子树中有比根节点大的节点则不能构成后序序列
        for( int cur = start; cur <= i; cur ++){
            if( a[cur] > a[end]) return false;
        }


        boolean left = a_judge(a, start, i);
        if( !left ) return false;//减少递归次数
        return  a_judge(a, i + 1, end - 1);

    }


    /**
     * 牛客网答案：与我的想法一样，只是选取了不一样的分界线。
     * 选取了上述的第一种分界线，这时是要在右子树中判断是否
     * 有小于根节点的节点，有则返回false。
     *
     */
    public boolean b_judge(int[] a, int start, int end){

        if(start >= end){
            return true;
        }
        int i = start;
        while(a[i] < a[end]){
            ++i;
        }
        for(int j=i;j<end;j++){
            if(a[j] < a[end]){
                return false;
            }
        }
        boolean left = b_judge(a,start,i-1);
        if(!left) return false;

        return  b_judge(a,i,end-1);
    }

}
