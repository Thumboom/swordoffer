package chapter4;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 */
public class Num31 {
    //我的解法：与牛客网上好的解法思路一致
    public boolean a_IsPopOrder(int [] pushA,int [] popA) {
        Stack stack = new Stack();
        int push = 0;
        int pop = 0;
        int length = pushA.length;
        while( push < length && pop < length){
            while(popA[pop] != pushA[push] ){
                if(push > 0 && popA[pop] == (int)stack.peek()){//看是否是stack中上一元素
                    pop ++;
                    stack.pop();
                    break;
                }
                stack.push(pushA[push]);
                push ++;
                if(push >= length || pop >= length) break;
            }
            if(push >= length || pop >= length) break;
            if(popA[pop] == pushA[push]){
                pop++;
                push++;
            }
        }
        while(pop < length) {
            if((int)stack.pop() != popA[pop++])
                return false;
        }

        return stack.isEmpty();

    }

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/d77d11405cc7470d82554cb392585106
     * 来源：牛客网
     *
     * 借用一个辅助的栈，遍历压栈顺序，先讲第一个放入栈中，这里是1，然后判断栈顶元素是不是出栈顺序的第一个元素，这里是4，很显然1≠4，所以我们继续压栈，
     * 直到相等以后开始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，这样循环等压栈顺序遍历完成，如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
     */
    public boolean b_IsPopOrder(int [] pushA,int [] popA) {

        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while(!s.empty() &&s.peek() == popA[popIndex]){
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        Num31 s = new Num31();
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{4,5,3,2,1};
        System.out.println(s.a_IsPopOrder(a,b));
    }
}
