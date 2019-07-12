package NumberOfIslands;

/**
 * Given a 2d grid map of '1's (land) and '0's (water),
 * count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    searchIsland(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void searchIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        searchIsland(grid, i + 1, j);
        searchIsland(grid, i - 1, j);
        searchIsland(grid, i, j + 1);
        searchIsland(grid, i, j - 1);
    }
}
