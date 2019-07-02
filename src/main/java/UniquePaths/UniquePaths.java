package UniquePaths;

//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
// The robot can only move either down or right at any point in time.
// The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//How many possible unique paths are there?
public class UniquePaths {
    //use dp
    public int uniquePaths(int m, int n) {
        int col = m;
        int row = n;
        int[][] dp = new int[row][col];
        for (int i = 0; i < col; i++) {
            dp[0][i] = 1;
        }
        for (int j = 0; j < row; j++) {
            dp[j][0] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[row-1][col-1];
    }


    /**
     * use recursive tle
     */
//    public int uniquePaths(int m, int n) {
//        int[] result = new int[1];
//        result[0] = 0;
//        recursive(1, 1, m, n, result);
//        return result[0];
//    }
//
//    private void recursive(int row, int col, int m, int n, int[] result) {
//        if (row == m && col == n) {
//            result[0]++;
//            return;
//        }
//        if (col < n) {
//            recursive(row, col + 1, m, n, result);
//        }
//        if (row < m) {
//            recursive(row + 1, col, m, n, result);
//        }
//    }
    public static void main(String[] args) {
        UniquePaths obj = new UniquePaths();
        System.out.println(obj.uniquePaths(7, 3));
    }
}
