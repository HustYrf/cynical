package WordSearch;

/**
 * @ClassName WordSearch
 * @Descripition TODO
 * @Author Administrator
 * @Date 2019/7/8 22:34
 **/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int row = board.length; //行数
        int col = board[0].length; // 列数
        char[] chars = word.toCharArray();
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int i1 = 0; i1 < col; i1++) {
                if (func(board, i, i1, chars, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean func(char[][] board, int start, int end, char[] chars, int index, boolean[][] visited) {
        if (index == chars.length) return true;
        if (start < 0 || end < 0 || start == board.length || end == board[start].length) return false; //好鸡儿困啊
        if (visited[start][end] || board[start][end] != chars[index]) return false;
        visited[start][end] = true;
        boolean flag = func(board, start - 1, end, chars, index + 1, visited) ||
                func(board, start + 1, end, chars, index + 1, visited) ||
                func(board, start, end + 1, chars, index + 1, visited) ||
                func(board, start, end - 1, chars, index + 1, visited);
        visited[start][end] = false;
        return flag;
    }

}
