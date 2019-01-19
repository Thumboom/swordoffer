package chapter2;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐
 * 标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人
 * 能够达到多少个格子？
 */
public class Num13 {
    public int count = 0;

    /**
     * 我的思路：dfs，深度优先。
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] able = new boolean[rows][cols];
        helper(threshold, able, rows, cols, 0, 0);
        return count;
    }


    public void helper(int threshold, boolean[][] able, int rows, int cols, int i, int j){
        if( i >= rows || i < 0 || j >= cols || j <0 ||  able[i][j] || sum(i) + sum(j) > threshold)
            return;
        able[i][j] = true;
        count ++ ;
        helper(threshold,able, rows, cols, i + 1, j);
        helper(threshold,able, rows, cols, i - 1, j);
        helper(threshold,able, rows, cols, i, j + 1);
        helper(threshold,able, rows, cols, i, j - 1);

    }

    public int sum(int i){
        int sum = 0;
        while( i >= 10){
            sum += i % 10;
            i /= 10;
        }
        sum += i;
        return sum;
    }
}
