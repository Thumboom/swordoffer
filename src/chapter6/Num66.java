package chapter6;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class Num66 {

    /**
     *牛客思路： 将数组b的所有元素摊开，没有A[i]的位置补1，可以看到一个主对角线为1
     * 的矩阵，用两个for循环，第一次先计算左下三角的值，第二个for循环计算右上三角的值。
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        B[0] = 1;

        for( int i = 1; i < length; i++){
            B[i] = B[i-1] * A[i-1];
        }

        int temp = 1;

        for( int j = length - 2; j >=0; j --){
            temp = temp * A[j+1];
            B[j] *= temp;
        }
        return B;
    }
}
