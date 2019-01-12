package chapter5;

public class Num39 {

    /**
     * 我的思路：将数组按序排好，如果有长度超过数组一半的数，则一定是数组中间的那个数
     * @param array
     * @return
     */
    public int my_MoreThanHalfNum_Solution(int [] array) {
        //选择排序
        int length = array.length;
        int min ;
        int pos;
        int temp;
        for( int i = 0; i < length; i ++){
            min = array[i];
            pos = i;
            for( int j = i + 1; j < length ; j ++) {
                if( array[j] < min) {
                    min = array[j];
                    pos = j;
                }
            }
            temp = array[i];
            array[i] = min;
            array[pos] = temp;
        }

        min = array[length/2];
        int count = 0;
        for( int i = 0; i < length; i ++){
            if( array[i] == min){
                count++;
            }
        }
        return count > length/2 ? min : 0;
    }


    /**
     * 好的的思路：
     * 如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
     * 在遍历数组时保存两个值：一是数组中一个数字，一是次数。遍历下一个数字
     * 时，若它与之前保存的数字相同，则次数加1，否则次数减1；若次数为0，则
     * 保存下一个数字，并将次数置为1。遍历结束后，所保存的数字即为所求。然
     * 后再判断它是否符合条件即可。
     *
     */
    public int MoreThanHalfNum_Solution(int [] array) {

        if(array.length < 1) return 0;
        int result = array[0];
        int count = 1;
        int length = array.length;
        for( int i = 1; i < length; i ++ ){
            if( count == 0) {
                result = array[i];
                count = 1;
            } else if( result != array[i] ){
                count --;
            } else {
                count ++;
            }
        }
        count = 0;
        for(int i = 0; i < length; i ++) {
            if( array[i] == result) count ++;
        }

        return count > length/2 ? result : 0;

    }


}
