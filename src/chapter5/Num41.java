package chapter5;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流
 * 中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数
 * 的平均值。我们使用Insert()方法读取数据流，使用GetMedian()
 * 方法获取当前读取数据的中位数。
 */
public class Num41 {
    PriorityQueue<Integer> small = new PriorityQueue<Integer>();
    PriorityQueue<Integer> big = new PriorityQueue<Integer>(new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Integer i1 = (Integer)o1;
            Integer i2 = (Integer) o2;
            return i2 - i1;

        }
    });


    /**
     * 我的思路：一个大顶堆保存一半的数，一个小顶堆保存另一半的数。
     * 如果新加入的数比大顶堆的顶要大或等于，就加入小顶堆中；小，就加入大顶堆。
     * 然后调整两个堆的元素数量，使得大顶堆中要么比小顶堆多1，要么一样。
     * @param num
     */
    public void Insert(Integer num) {

        if( big.isEmpty() || big.peek() > num) big.add(num);
        else small.add(num);
        adjust();
    }

    private void adjust() {
        if( big.size() == small.size() + 2) small.add(big.poll());
        if( small.size() == big.size() + 1) big.add(small.poll());

    }

    public Double GetMedian() {

        return small.size() == big.size() ? (small.peek() + big.peek()) / 2.0 : 1.0 * big.peek() ;
    }

}
