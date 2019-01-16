package chapter5;


/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，
 * 当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符
 * 是"g"。当从该字符流中读出前六个字符“google"时，第一个只出
 * 现一次的字符是"l"
 */
public class Num50_2 {
    String first = "";
    String str = "";
    int[] count = new int[128];
    int start = -1;

    /**
     * 思路：因为数据的范围时比较小，所以可以利用桶去统计出现的次数，
     * 再实现一个队列保留各字符第一次出现的位置就能满足要求。
     * @param ch
     */
    public void Insert(char ch)
    {
        str += ch;
        start++;
        if( count[ch - ' '] == 0)
            first += ch;
        count[ ch - ' ']++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int strLength = str.length();
        for( int i = 0; i < strLength; i++){
            char c = str.charAt(i);
            if( count[c - ' '] == 1){
                return c;
            }
        }
        return '#';
    }
}
