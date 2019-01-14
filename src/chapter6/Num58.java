package chapter6;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他
 * 向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子
 * 应该是“I am a student.”。Cat对一一的翻转这些单词顺序可
 * 不在行，你能帮助他么？
 */

public class Num58 {
    /**
     * 我的思路： 由于题目没有描述空间复杂度，所以翻转顺序这种事情可
     * 以借助栈去实现。但是这应该不是面试官想考察的，这题应该要限制
     * 空间复杂度为O（1），我这里没有满足要求
     * @param str
     * @return
     */
    public String my_ReverseSentence(String str) {
        if(str.length() == 0) return "";
        String[] strInv = str.split(" ");
        if(strInv.length == 0)return str;
        StringBuilder sb = new StringBuilder();
        for( int i = strInv.length - 1; i >= 0; i --){
            sb.append(strInv[i]);
            if( i != 0)
                sb.append(" ");
        }
        return sb.toString();
    }


    /**
     * 牛客思路：先整体翻转一次句子，保证单词间的顺序是对的
     * 再翻转单词里面字母的顺序，保证单词是正确的。
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int blank = -1;
        int nextBlank = -1;
        for( int i = 0; i < chars.length; i ++){
            if( chars[i] == ' '){
                nextBlank = i;
                reverse(chars, blank + 1, nextBlank - 1);
                blank = nextBlank;
            }
        }
        //处理最后一个单词
        reverse(chars, nextBlank + 1, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while( start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            end --;
            start ++;
        }
    }

}
