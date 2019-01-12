package chapter5;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 */
public class Num51 {
    int[] temp;
    int count = 0;

    /**
     * 我的想法：左神有提到过，这题的可以用归并排序，解决
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {

        temp = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        return count;
    }

    public void mergeSort(int [] array, int left, int right ){

        if( left>=right) return;
        int mid = left + ((right - left)>>1);

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, right);
    }

    private void merge(int[] array, int left, int right) {
        int mid = left + ((right - left)>>1);
        int p1 = left;
        int p2 = mid + 1;
        int num = 0;
        while( p1 <= mid && p2 <= right  ) {
            if( array[p1] <= array[p2]) {
                temp[num++] = array[p1++];
            }
            //这里是关键，当右边的数组的数比左边的小的时候，其实就存在左边剩余没比较的数
            //的个数个逆序对。
            if( array[p1] > array[p2]){
                temp[num++] = array[p2++];
                count = (count + (mid - p1 + 1) * 1);
                if( count >= 1000000007){
                    count = count  % 1000000007;
                }
            }
        }

        while( p1 <= mid){
            temp[num++] = array[p1++];
        }

        while( p2 <= right){
            temp[num++] = array[p2++];
        }

        for( int i = 0; i < num; i ++){
            array[left + i] = temp[i];
        }

    }

}
