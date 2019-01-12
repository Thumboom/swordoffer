package chapter5;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8
 * 这8个数字，则最小的4个数字是1,2,3,4,
 */
public class Num40 {
    /**
     *
     * 牛客思路：用大顶堆去存储k个数，当有其他数比堆顶元素大时，就
     * 替换掉堆顶元素。以后遇到最大最小k个数时都可以用堆顶元素作为
     * 上下界减少比较次数。
     *
     * @param input
     * @param k
     * @return
     */

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if( input.length == 0 || k == 0 || k > input.length)
            return list;

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for( int i = 0; i < input.length; i ++ ){
            if( i < k ) {
                queue.offer(input[i]);
            } else if( queue.peek() > input[i]){
                queue.poll();
                queue.offer(input[i]);
            }

        }


        for( int i = 0; i < k; i ++) {
            list.add(queue.poll());
        }
        return  list;
    }
}
