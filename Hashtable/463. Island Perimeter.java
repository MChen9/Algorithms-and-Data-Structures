class Solution {
    /**
     * [Reference](https://leetcode.com/problems/island-perimeter/discuss/95001/clear-and-easy-java-solution)
     * Key point: 
     *   Sum up every edges, if there is no island and on the boundary.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int islandPerimeter(int[][] grid) {
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    for (int[] d: dirs) {
                        int row = i + d[0], col = j + d[1];
                        if (row < 0 || row >= grid.length
                           || col < 0 || col >= grid[0].length ||
                           grid[row][col] == 0)
                            perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }
}
