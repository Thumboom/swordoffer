package chapter2;


/**
 * 求一个数的二进制数中的1的个数
 */
public class Num15 {
    //解法一：每个二进制位都验证一下是否存在1
    public int a_NumberOf1(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((n>>i & 1) >= 1){
                count++;
            }
        }
        return count;
    }

    /**
     * 解法二：一个数减一再与原数做与运算，会
     * 得到这么一个数，该数的的二进制数是原数
     * 最右边的1变成0的结果
     */

    public int b_NumberOf1(int n) {
        int count = 0;
        while( n != 0) {
            n = (n - 1) & n;
            count++;
        }
        return count;
    }
}
