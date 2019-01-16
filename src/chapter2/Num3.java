package chapter2;


/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复
 * 的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 */
public class Num3 {

    /**
     * 我的思路：利用桶去记录数组中的数字出现的次数，遇到出现次数等于2的就返回当前数字。
     * 时间复杂度为O（n），空间复杂度为O（n）
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean my_duplicate(int numbers[],int length,int [] duplication) {
        if( numbers == null) return false;

        int[] temp = new int[numbers.length];

        for( int i = 0; i < numbers.length; i++){
            temp[numbers[i]]++;

            if( temp[numbers[i]] >= 2){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 题目里写了数组里数字的范围保证在0 ~ n-1 之间，所以可以利用现有数组设置标志，
     * 当一个数字被访问过后，可以设置对应位上的数 + n，之后再遇到相同的数时，会发
     * 现对应位上的数已经大于等于n了，那么直接返回这个数即可。其实思想也是利用桶，
     * 一般遇到这种数据保证在一定范围内的问题，都可以考虑用桶。但是这里的做法是利用
     * 现有的数组作桶，所以省下很多空间，空间复杂度为O（1）；
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int index = 0;

        for(int i = 0; i < length; i ++) {
            index = numbers[i];
            if( index >= length )
                index -= length;

            numbers[index] += length;
            if( numbers[index] >= 2*length){
                duplication[0] = index;
                return true;
            }

        }
        return false;
    }



}
