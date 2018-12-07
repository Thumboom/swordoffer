package chapter4;

import java.util.Stack;

/**
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳��
 * ����4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
 * ��ע�⣺���������еĳ�������ȵģ�
 *
 */
public class Num31 {
    //�ҵĽⷨ����ţ�����ϺõĽⷨ˼·һ��
    public boolean a_IsPopOrder(int [] pushA,int [] popA) {
        Stack stack = new Stack();
        int push = 0;
        int pop = 0;
        int length = pushA.length;
        while( push < length && pop < length){
            while(popA[pop] != pushA[push] ){
                if(push > 0 && popA[pop] == (int)stack.peek()){//���Ƿ���stack����һԪ��
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
     * ���ӣ�https://www.nowcoder.com/questionTerminal/d77d11405cc7470d82554cb392585106
     * ��Դ��ţ����
     *
     * ����һ��������ջ������ѹջ˳���Ƚ���һ������ջ�У�������1��Ȼ���ж�ջ��Ԫ���ǲ��ǳ�ջ˳��ĵ�һ��Ԫ�أ�������4������Ȼ1��4���������Ǽ���ѹջ��
     * ֱ������Ժ�ʼ��ջ����ջһ��Ԫ�أ��򽫳�ջ˳������ƶ�һλ��ֱ������ȣ�����ѭ����ѹջ˳�������ɣ��������ջ����Ϊ�գ�˵���������в��Ǹ�ջ�ĵ���˳��
     */
    public boolean b_IsPopOrder(int [] pushA,int [] popA) {

        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //���ڱ�ʶ�������е�λ��
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);
            //���ջ��Ϊ�գ���ջ��Ԫ�ص��ڵ�������
            while(!s.empty() &&s.peek() == popA[popIndex]){
                //��ջ
                s.pop();
                //�����������һλ
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
