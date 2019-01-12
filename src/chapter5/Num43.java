package chapter5;


/**
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出
 * 现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题
 * 更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到
 * n 中1出现的次数）。
 */
public class Num43 {


    /**
     * 牛客好的思路：归纳总结：
     * k = n % (i * 10)
     * count(i) = (n / (i * 10)) * i + (if(k > i * 2 - 1) i else if(k < i) 0 else k - i + 1)
     *
     * 分类讨论，计算个位，十位，百位等。i为位数。
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0)
            return 0;
        int count = 0;
        for(long i = 1; i <= n; i *= 10){
            long diviver = i * 10;
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);
        }
        return count;
    }
}
