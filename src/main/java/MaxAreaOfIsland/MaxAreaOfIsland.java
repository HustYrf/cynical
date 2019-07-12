package MaxAreaOfIsland;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxCnt = 0;


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    maxCnt = Math.max(maxCnt, dfsSearchIsland(grid, i, j));
                }
            }
        }
        return maxCnt;
    }


    private int dfsSearchIsland(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int size = 1;
        size += dfsSearchIsland(grid, i + 1, j);
        size += dfsSearchIsland(grid, i - 1, j);
        size += dfsSearchIsland(grid, i, j + 1);
        size += dfsSearchIsland(grid, i, j - 1);

        return size;
    }
}
