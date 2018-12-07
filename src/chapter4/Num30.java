package chapter4;

import java.util.Stack;

/**
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��
 * ������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1����
 */
public class Num30 {
    /**
     * �ҵĽⷨ����������ջ��ʹ��ί�н�����һ����Ϊ�����������ܵ�ջ
     * ��һ��ջ�洢������ջ����С����������Ҫ��СԪ��ʱ��ֱ�ӽ�ջ��Ԫ�ص���
     */
    private Stack stack = new Stack();
    private Stack minStack = new Stack();//���մӴ�С��˳��洢ѹ��ջ��Ԫ��
    private int min = 1000;
    public void push(int node) {
        if(stack.empty()) min = node;//��ʼ��min
        stack.push(node);
        if(node <= min) {
            min = node;
            minStack.push(min);
        }
    }

    public void pop() {
        //������ջ��Ԫ������СԪ�ص�ʱ����һ��ջҲ�õ�����Ԫ��
        if((int)stack.peek() == (int)minStack.peek()) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return (int)stack.peek();
    }

    public int min() {
        return (int)minStack.peek();
    }
}
