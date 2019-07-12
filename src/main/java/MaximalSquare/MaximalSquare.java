package MaximalSquare;


/**
 * 使用dp动态规划的思想
 *
 * 先对第一行和第一列遍历一遍，如果为’1'，max设置为1
 *
 *每一个matrix[i][j]为正方形右下角的话，其左边元素，上边元素和左上边元素都一定是一个正方形的右下角
 * 取三个中正方形边长最小的一个加1就是当前的边长
 *
 *动态规划公式为dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
 *
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int row = matrix.length; //行数
        int col = matrix[0].length; // 列数
        int[][] dp = new int[row][col];
        int max = 0;  //最大正方形边长
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                max = 1;
            }
        }

        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                max = 1;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max * max;
    }

}
