package chapter6;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Num53 {


    /**
     * 我的思路：用二分查找法找到对应的数，然后在以该数位置为基础，向两边查找
     * 边界
     * @param array
     * @param k
     * @return
     */
    public int my_GetNumberOfK(int [] array , int k) {

        if(array.length == 0) return 0;
        int index = find(array, 0, array.length - 1, k);
        if( index == -1) return 0;
        int left = index, right = index;
        while(left >= 0 && array[left] == k) left--;
        while( right < array.length && array[right] == k) right ++;

        return right - left - 1;
    }

    public int find(int []array, int left, int right, int k){
        int mid =  (left + right)>>1;
        while (left<= right){
            if( k < array[mid]){
                right = mid - 1;
            } else if( k > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }

            mid = (left + right )>>1;
        }
        return -1;
    }


    /**
     * 牛客好的思路：直接用二分查找法找到最左边的数，再用二分查找法找到最右边的数
     */
    public int GetNumberOfK(int [] array , int k) {

        if(array.length == 0) return 0;
        int left = findFirst(array, 0, array.length - 1, k);
        int right = findLast(array, 0, array.length - 1, k);

        if( left == -1 && right == -1) return 0;
        else return right - left + 1;

    }

    public int findFirst(int []array, int left, int right, int k){

        int mid =  (left + right)>>1;

        while (left<= right){
            if( k < array[mid]){
                right = mid - 1;
            } else if( k > array[mid]) {
                left = mid + 1;
            } else {
                if( mid == 0 || array[mid - 1] != k)//保证找到的是最左边的数
                    return mid;
                else {
                    right = mid - 1;
                }
            }

            mid = (left + right )>>1;
        }

        return -1;
    }

    public int findLast(int []array, int left, int right, int k){
        int mid =  (left + right)>>1;
        while (left<= right){
            if( k < array[mid]){
                right = mid - 1;
            } else if( k > array[mid]) {
                left = mid + 1;
            } else {
                if( mid == array.length - 1 || array[mid + 1] != k)//保证找到的是最右边的数
                    return mid;
                else {
                    left = mid + 1;
                }
            }
            mid = (left + right )>>1;
        }
        return -1;
    }
}
