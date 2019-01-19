package chapter2;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向
 * 下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这
 * 个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串
 * "bcced"的路径， 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了
 * 矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Num12 {

    /**
     * 我的思路：典型的回溯法
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean[][] visited  = new boolean[rows][cols];

        char[][] myMatrix = new char[rows][cols];

        for( int i = 0 ; i < matrix.length; i ++){
            myMatrix[i / cols][ i % cols] = matrix[i];
        }

        for( int i = 0; i < rows; i ++){
            for( int j = 0; j < cols; j ++){
                if( str[0]==(myMatrix[i][j])){
                    visited[i][j] = true;
                    if( help(myMatrix, visited, i, j, str, 0)){
                        return true;
                    }

                    visited[i][j] = false;
                }
            }
        }
        return false;

    }

    public boolean help(char[][] matrix, boolean[][] visited,int rows, int cols, char[] str, int index){
        if( index == str.length - 1 && matrix[rows][cols] ==  str[index]){
            return true;
        }

        else if( matrix[rows][cols] != (str[index])) {
            return false;
        }

        boolean left = false;
        boolean right = false;
        boolean down = false;
        boolean up = false;

        if( rows + 1 < matrix.length && !visited[rows + 1][cols ]) {
            visited[rows + 1][cols] = true;
            down = help(matrix, visited, rows + 1, cols, str, index + 1);
            if(down) return true;
            visited[rows+1][cols] = false;
        }

        if( cols + 1 < matrix[0].length && !visited[rows][cols + 1]){
            visited[rows][cols + 1] = true;
            right = help(matrix, visited, rows , cols + 1, str, index + 1);
            if(right) return true;
            visited[rows][cols + 1] = false;
        }
        if( cols - 1 >=  0 && !visited[rows][cols - 1]){
            visited[rows][cols - 1] = true;
            left = help(matrix, visited, rows , cols - 1, str, index + 1);
            if( left ) return true;
            visited[rows][cols - 1] = false;
        }
        if( rows - 1 >= 0 && !visited[rows - 1][cols ]) {
            visited[rows - 1][cols] = true;
            up = help(matrix, visited, rows - 1, cols, str, index + 1);
            if(up) return true;
            visited[rows-1][cols] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Num12 t = new Num12();

        char[] matrix = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] str = "SLHECCEIDEJFGGFIE".toCharArray();
        System.out.println(t.hasPath(matrix, 5, 8, str));


    }
}
