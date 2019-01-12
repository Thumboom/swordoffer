package chapter5;

import static java.lang.Math.min;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺
 * 序的第N个丑数
 */
public class Num49 {

    /**
     * 牛客思路：丑数就是丑数乘2、3、5得来的数。因为要排序
     * 所以，维护一个数组，存有初始的几个丑数，然后分别乘以
     * 2、3、5，选出最小的丑数当做是下一个要生成的丑数
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {


        if( index < 7) return index;
        int[] ugly = new int[index];
        ugly[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        for( int i = 1; i < index; i++){
            ugly[i] = min(ugly[p2] * 2, min(ugly[p3] * 3, ugly[p5] * 5));
            if( ugly[i] == ugly[p2] * 2) p2++;//移动2要乘的数的位置，防止重复相乘
            if( ugly[i] == ugly[p3] * 3) p3++;
            if( ugly[i] == ugly[p5] * 5) p5++;
        }
        return ugly[index-1];
    }
}
