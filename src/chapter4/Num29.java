package chapter4;

import java.util.ArrayList;


/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Num29 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int right = matrix[0].length;
        int down = matrix.length;
        int up = 0;
        int left = -1;
        int row = up;
        int col = 0;

        while( up < down && right > left) {

            for( col = left + 1; col < right; col ++)
                list.add(matrix[up][col]);

            right --;

            if(right <= left) break;//结束，防止重复打印，例如，当矩阵只有两列时
            for( row = up + 1; row < down; row ++)
                list.add(matrix[row][right]);

            down --;

            if(down <= up) break;   //结束，防止矩阵只有一行时从右到左重复打印
            for( col = right - 1; col > left; col --)
                list.add(matrix[down][col]);

            left ++;

            if(right <= left) break;
            for( row = down - 1; row > up; row --)
                list.add(matrix[row][left]);

            up ++;

        }

        return list;
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3,4}};
        Num29 s = new Num29();

        System.out.println(s.printMatrix(a));
    }
}
