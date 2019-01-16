package chapter6;

/**
 * 0,1,...,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里
 * 删除第m个数字。求出这个圆圈里剩下的最后一个数字
 */
public class Num62 {

    /**
     * 数学思路：参考剑指offer62题或者
     * https://www.nowcoder.com/questionTerminal/11b018d042444d4d9ca4914c7b84a968
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if( n < 1 || m < 1) return -1;

        int last = 0;
        for( int i = 2; i<=n ; i++)
            last = (last + m) % i;

        return last;
    }

    /**
     * 经典解法：用环这个数据结构去模拟整个过程
     * @param n
     * @param m
     * @return
     */

    public static int findLastNumber(int n,int m){
        if(n<1||m<1) return -1;
        int[] array = new int[n];
        int i = -1,step = 0, count = n;
        while(count>0){   //跳出循环时将最后一个元素也设置为了-1
            i++;          //指向上一个被删除对象的下一个元素。
            if(i>=n) i=0;  //模拟环。
            if(array[i] == -1) continue; //跳过被删除的对象。
            step++;                     //记录已走过的。
            if(step==m) {               //找到待删除的对象。
                array[i]=-1;
                step = 0;
                count--;
            }
        }
        return i;//返回跳出循环时的i,即最后一个被设置为-1的元素
    }

}
