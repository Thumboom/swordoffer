package chapter5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class Num45 {
    /**
     * 牛客的思路：先把整数类型数组变为字符串类型数组，再对字符串数组排序。
     * 排序规则是：当字符串ab小于ba时，a小于b； 当ab大于ba时， a大于b,否则相等。
     * 然后再进行拼接。
     */
    public String PrintMinNumber(int [] numbers) {

        String[] s = new String[numbers.length];

        for( int i = 0; i < numbers.length; i ++){
            s[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length; i ++){
            sb.append(s[i]);
        }

        return sb.toString();
    }

}
