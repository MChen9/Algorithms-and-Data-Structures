class Solution {
    /**
     * [Reference](https://leetcode.com/articles/number-of-islands/)
     * Key points:
     *   Count number of roots invoking DFS, mark every slot as '0' 
     *   if it was '1'
     *
     * Time Complexity: O(m*n)
     * Space Complexity: O(m*n), since DFS invokes stack frames
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    DFS(i, j, grid);
                }    
            }
        }
        return res;
    }
    
    private void DFS(int i, int j, char[][] grid) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            DFS(i + 1, j, grid);
            DFS(i - 1, j, grid);
            DFS(i, j + 1, grid);
            DFS(i, j - 1, grid);
        }
    }
}
