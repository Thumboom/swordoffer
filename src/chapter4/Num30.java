package chapter4;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中
 * 所含最小元素的min函数（时间复杂度应为O（1））
 */
public class Num30 {
    /**
     * 我的解法：设置两个栈，使用委托将其中一个作为含有正常功能的栈
     * 另一个栈存储依次入栈的最小的数。当需要最小元素时，直接将栈顶元素弹出
     */
    private Stack stack = new Stack();
    private Stack minStack = new Stack();//按照从大到小的顺序存储压入栈的元素
    private int min = 1000;
    public void push(int node) {
        if(stack.empty()) min = node;//初始化min
        stack.push(node);
        if(node <= min) {
            min = node;
            minStack.push(min);
        }
    }

    public void pop() {
        //当弹出栈的元素是最小元素的时候，另一个栈也得弹出该元素
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
