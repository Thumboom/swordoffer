package chapter6;

import java.util.HashSet;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
 * 请写程序找出这两个只出现一次的数字。剑指offer上要求时间复杂度
 * 为O（n），空间复杂度O（1）
 *
 */
public class Num56 {
    /**
     * 我的思路：由于其他数出现偶数次，所以可以往hashset里
     * 添加元素，如果里面已经有了，就把该数取出来。最后一定
     * 剩下两个元素。但是这空间复杂度其实不符合剑指offer的要求。
     */

    public void my_FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashSet set = new HashSet();

        int cur;
        for( int i = 0; i < array.length; i ++){
            cur = array[i];
            if( set.add(cur) == false){
                set.remove(cur);
            }
        }
        int i = 0;
        for( Object a: set){
            if( i == 0){
                num1[0] = (int)a;
            } else {
                num2[0] = (int)a;
            }

            i++;
        }
    }

    /**
     * 牛客好的思路：关键在于亦或运算，两个相同的数的
     * 异或运算后一定为0，对原数组每个数都进行
     * 异或运算，结果一定是两个只出现一次的数的异或运算
     * 的结果。然后再找到这个结果中第一出现1的位置，根据
     * 这点将原数组分为两个子数组，两个只出现过一次的数
     * 一定会在两个不同的数组里，再从头对分好的子数组进行
     * 异或运算，就可以得到想要的结果了。这里分子树组时，
     * 不必真的分配内存去装这些分好的元素，而是直接在原
     * 数组的基础上用判断的方法。
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp = 0;

        for( int i = 0; i < array.length; i ++){
            temp^=array[i];
        }
        int index = findFirst1(temp);
        num1[0] = 0;
        num2[0] = 0;

        for( int i = 0; i < array.length; i++){
            //这里相当于把原数组分成两个子数组，并顺便运算
            if( isBit1(array[i], index)){
                num1[0]^=array[i];
            } else {
                num2[0]^= array[i];
            }
        }
    }

    private boolean isBit1(int i, int index) {
        return ((i>>index ) & 1) == 1;
    }

    private int findFirst1(int temp) {
        int index = 0;
        while( (temp & 1) != 1 && index < 32) {
            temp >>= 1;
            index ++;
        }
        return index;
    }


}
