package chapter6;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你
 * 把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求
 * 输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class Num58_2 {
    /**
     * 我的思路：左循环k位其实就是把左边k位粘贴到右边去
     * @param str
     * @param n
     * @return
     */
    public String my_LeftRotateString(String str,int n) {
        String front = null;
        String back = null;
        int length = str.length();
        if( length == 0) return "";
        int move = n % length;

        if( move == 0) return str;

        front = str.substring(0, move);
        back = str.substring(move, length);

        return back + front;

    }

    /**
     * 牛客好的思路：跟我的思路差不多，但是首先是将字符串复制粘贴起来
     * 形成一个重复1次的字符串，如abc，变成abcabc。然后直接取
     * 第k位开始的n位字符。
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        int length = str.length();
        if( length == 0) return "";
        int k = n % length;
        str += str;
        return str.substring(k, k + length);
    }

}
