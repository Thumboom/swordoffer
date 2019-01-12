package chapter5;

/**
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,
 * 当向量全为正数的时候,问题很好解决。但是,如果向量中包含
 * 负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第
 * 0个开始,到第3个为止)。给一个数组，返回它的最大连续子序
 * 列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class Num41 {

    /**
     * 我的思路：包含负数的情况什么条件下才能作为最大值的一部分呢？
     * 当前面的正数与后面连续存在的负数的和为正数时，其后面还有正数时，
     * 才能当成最大连续子向量的一部分。设置标志保存目前找到的最大连续
     * 子向量的开始和结束位置和其最大值，然后继续遍历剩下的子向量。当
     * 遇到有负数的情况时，如果连续和小于0， 则重新在剩下的子向量中去
     * 寻找可能存在的连续子向量。
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 1) return array[0];
        int max_start = 0;
        int max_end = 0;

        int max = array[0];

        int try_start = 0;
        int try_end = 0;
        int try_max = 0;

        for( int i = 0; i < array.length; i ++){
            try_max += array[i];

            if( try_max < 0 && try_max < max) {
                try_start = i + 1;
                try_end = i + 1;
                try_max = 0;
                continue;
            }
            try_end = i;
            if( try_max > max){
                max = try_max;
                max_start = try_start;
                max_end = try_end;
            }
        }
        return max;
    }
}
