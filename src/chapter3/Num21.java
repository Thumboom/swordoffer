package chapter3;


/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Num21 {

    //为了维持数组内偶数和奇数的相对位置不变，使用插入排序算法。
    public void reOrderArray(int [] array) {
        int temp;
        int length = array.length;
        int j;
        for(int i = 1; i < length; i ++){
            if( array[i] % 2 == 1){
                j = i;
                temp = array[i];
                while( j > 0 && array[j - 1] % 2 == 0) {
                    array[j] = array[j - 1];
                    --j;
                }
                array[j] = temp;
            }
        }
        for(int t: array)
            System.out.print(t + ",");

    }

    public static void main(String[] args) {
        Num21 t = new Num21();
        int[] a = new int[]{1,2,3,4,7};
        t.reOrderArray(a);
        for(int i: a){
            System.out.print(i + ",");
        }
    }
}
