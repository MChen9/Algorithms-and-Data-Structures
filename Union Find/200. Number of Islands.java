class Solution {
    /**
     * [Reference](https://leetcode.com/articles/number-of-islands/)
     * Key points:
     *   1. Only union vertical or horizontal '1';
     *   2. Every disjoint set has their own parent;
     *   3. Path compression on every find();
     *   4. Implement as an array with m*n length;
     *   5. Use int[] rank to record their ranks, union nodes have same rank,
     *      so rank++ only if rankX = rankY;
     *   6. Compare their parents rank if they have parents.
     *
     * Time Complexity: O(m*n), since m rows and n cols.
     * Space Complexity: O(m*n). Array's length is m*n.
     */
    class DisjointSet {
        int[] rank, parent;
        int num;
        
        public DisjointSet(char[][] grid) {
            int m = grid.length, n = grid[0].length;
            rank = new int[m*n];
            parent = new int[m*n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i*n + j] = -1;
                        num++;
                    }
                }
            }
        }
        
        // path compression
        int find(int x) {
            if (parent[x] < 0) return x;
            parent[x] = find(parent[x]);
            return parent[x];
        }
        
        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                    
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                    
                } else {
                    parent[rootY] = rootX; 
                    rank[rootX]++;
                }
                
                num--;
            }
        }
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        DisjointSet djSet = new DisjointSet(grid);
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    if (i + 1 < m && grid[i + 1][j] == '1') 
                    djSet.union(i * n + j, (i + 1)*n + j);
                if (i - 1 >= 0 && grid[i - 1][j] == '1')
                    djSet.union(i * n + j, (i - 1)*n + j);
                if (j + 1 < n && grid[i][j + 1] == '1')
                    djSet.union(i * n + j, i * n + (j + 1));
                if (j - 1 >= 0 && grid[i][j - 1] == '1')
                    djSet.union(i * n + j, i * n + (j - 1));
                }
            }
        }
        return djSet.num;
    }
}
