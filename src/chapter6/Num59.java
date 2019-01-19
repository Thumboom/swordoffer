package chapter6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，
 * 如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑
 * 动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}
 * 的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 */
public class Num59 {
    /**
     * 我的思路：用大顶堆存储数据，新建一个类，成员变量有值和下标值，
     * 一开始先放入size个元素，后面每移动一步就加入一个，每次都取堆顶，
     * 判断下标值有没有过期，过期则移除并接着取下一个堆顶。
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        PriorityQueue<WindowEle> q =  new PriorityQueue<WindowEle>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((WindowEle)o2).e - ((WindowEle)o1).e;
            }
        });

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < size && i < num.length; i ++){
            WindowEle we = new WindowEle(num[i], i);
            q.add(we);
        }
        WindowEle e = q.peek();
        list.add(e.e);
        for( int i = 1; i + size <= num.length; i ++){
            WindowEle we = new WindowEle(num[i + size - 1], i + size - 1);
            q.add(we);
            e = q.peek();
            while( e.index < i){
                e = q.poll();
            }
            list.add(e.e);
        }

        return list;
    }
}

class WindowEle{
    public Integer e;
    public int index;

    public WindowEle(Integer e, int index){
        this.e = e;
        this.index = index;
    }


}
