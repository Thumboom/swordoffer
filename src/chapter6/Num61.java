package chapter6;

import java.util.Arrays;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,
 * 发现里面居然有2个大王,2个小王(一副牌原
 * 本是54张^_^)...他随机从中抽出了5张牌,想测
 * 测自己的手气,看看能不能抽到顺子,如果抽到
 * 的话,他决定去买体育彩票,嘿嘿！！“红心A,
 * 黑桃3,小王,大王,方片5”,“Oh My God!”不
 * 是顺子.....LL不高兴了,他想了想,决定大\小
 * 王可以看成任何数字,并且A看作1,J为11,Q为
 * 12,K为13。上面的5张牌就可以变成“1,2,3,4,5”
 * (大小王分别看作2和4),“So Lucky!”。LL决定
 * 去买体育彩票啦。 现在,要求你使用这幅牌模拟
 * 上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。
 * 为了方便起见,你可以认为大小王是0。
 */

public class Num61 {

    /**牛客思路
     * 1、排序
     * 2、计算所有相邻数字间隔总数
     * 3、计算0的个数
     * 4、如果2、3相等，就是顺子
     * 5、如果出现对子，则不是顺子
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        int numOf0 = 0;
        int gap = 0;

        if( numbers.length == 0) return false;

        Arrays.sort(numbers);

        for( int i = 0; i < numbers.length - 1; i ++){
            if( numbers[i] == 0) numOf0 ++;
            else {
                if( numbers[i] == numbers[i + 1])
                    return false;

                gap += numbers[i+1] - numbers[i] - 1;
            }
        }

        if( numOf0 >= gap) return true;

        return false;

    }
}
