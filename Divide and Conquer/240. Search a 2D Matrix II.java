class Solution {
    /**
     * [Reference](https://leetcode.com/articles/search-a-2d-matrix-ii/)
     * Key points:
     *   1. Different from [74. Search a 2D Matrix], the last element of last row
     *     is not neccessarily larger than the first element of current row;
     *   2. Increase from left to right and from up to down, hence, start from 
     *      bottom left, if pivot is larger than target, we move up, else, move
     *      right.
     *       
     * Time Complexity: O(m + n). Because row can only be decremented mm times and 
     * col can only be incremented nn times before causing the while loop to terminate, 
     * the loop cannot run for more than n+mn+m iterations. 
     * Space Complexity: 0(1).
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        int i = row - 1, j = 0;
        int pivot;
        while (i >= 0 && j < col) {
            pivot = matrix[i][j];
            if (pivot == target)
                return true;
            if (pivot > target)
                i--;
            else
                j++;
        }
        return false;
    }
}
