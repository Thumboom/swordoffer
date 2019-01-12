package chapter5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置, 如果
 * 没有则返回 -1（需要区分大小写）
 */
public class Num50 {
    /**
     * 我的思路：用一个长度为60的数组，保存每个字母出现的次数，再用队列
     * 保存每一个字母第一次出现的位置和字符本身。
     */
    public int FirstNotRepeatingChar(String str) {
        int[] chrct = new int[60];
        Queue<Pos> q = new LinkedList<Pos>();
        for( int i = 0; i < 60; i ++) {
            chrct[i] = 0;
        }

        int length = str.length();
        char c;
        for( int i = 0; i < length; i ++){
            c = str.charAt(i);
            chrct[c - 'A'] ++;//字母对应的次数增加
            //保留字母第一次出现的位置，用队列保存可以保证顺序
            if(chrct[c-'A'] == 1) {
               q.offer(new Pos(c, i));
            }

        }

        for(Pos p : q){
            if( chrct[p.c - 'A'] == 1)
                return p.pos;
        }

        return -1;

    }
    class Pos{
        char c;
        int pos;

        public Pos(char c, int pos){
            this.c = c;
            this.pos = pos;
        }
    }

}
