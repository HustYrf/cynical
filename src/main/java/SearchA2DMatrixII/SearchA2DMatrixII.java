package SearchA2DMatrixII;

/**
 * @ClassName SearchA2DMatrixII
 * @Descripition TODO
 * @Author Administrator
 * @Date 2019/7/14 16:24
 **/
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;  // 行数
        if (row == 0) {
            return false;
        }
        int col = matrix[row - 1].length; // 列数


        int index = Math.min(row, col);


        for (int i = 0; i < index; i++) {
            if (searchBinary(matrix, i, index - 1, target, -1, i)) {
                return true;
            }
            if (searchBinary(matrix, i, index - 1, target, i, -1)) {
                return true;
            }
        }

        if (row > index) {
            for (int i = index; i < row; i++) {
                if (searchBinary(matrix, 0, col - 1, target, i, -1)) {
                    return true;
                }
            }
        }

        if (col > index) {
            for (int j = index; j < col; j++) {
                if (searchBinary(matrix, 0, row - 1, target, -1, j)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean searchBinary(int[][] matrix, int start, int end, int target, int row, int col) {
        int mid, value;
        while (start <= end) {
            mid = (start + end) / 2;
            if (row == -1) {
                value = matrix[mid][col];
            } else {
                value = matrix[row][mid];
            }
            if (target == value) {
                return true;
            } else if (target < value) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

}
