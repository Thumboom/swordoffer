package chapter6;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Num57 {
    /**
     * 我的思路：使用双指针滑动，两个指针开始时紧挨着一前一后，当两个指针的和小于目标值的时候，
     * 先走的指针向右滑动；当两个指针的和大于目标值的时候，后面的指针先右滑动，
     * 并且前面的指针往回滑动。这个思想是从Num57_2那里继承过来的，牛客上其他
     * 的解法也是使用双指针，不过一个指针指向最小那个，一个指针指向最大那个。
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int cur;
        int plow = 0, phigh = 1;
        ArrayList<Integer> res = new ArrayList<Integer>();

        while( plow < phigh && phigh < array.length){
            cur = array[plow] + array[phigh];
            if( cur == sum){
                res.add(array[plow]);
                res.add(array[phigh]);
                break;
            } else if( cur < sum){
                phigh ++;
            } else {
                plow ++;
                phigh --;
            }
        }
        return res;
    }


}
