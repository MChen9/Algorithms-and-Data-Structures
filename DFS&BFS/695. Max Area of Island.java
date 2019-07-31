class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) return 0;
        int maxRes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                maxRes = Math.max(dfs(grid, i, j), maxRes);
            }
            
        }
        return maxRes;
    }
    
    private int dfs(int[][] grid, int x, int y) {
        if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || grid[x][y] == 0 || grid[x][y] == -1)
            return 0;
        int max = 1;
        grid[x][y] = -1;
        for (int[] d: dirs) {
            max += dfs(grid, x + d[0], y + d[1]);    
        }
        return max;
    }
    
}
