class Solution {
    /**
     * [Reference](https://leetcode.com/articles/search-in-2d-matrix/)
     * Key points:
     *   1. Since the first integer of each row is greater than the last 
     *      integer of the previous row, we can flatten the matrix to a
     *      length of m * n sorted array;
     *   2. Then the pivot position can be [mid / n][mid % n], n is the 
     *      length of row, so we can use standard binary search.
     *
     * Time Complexity: O(log mn).
     * Space Complexity: O(1).
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int n = matrix[0].length;
        int len = matrix.length * n;
        int left = 0, right = len - 1;
        int mid, pivot;
        while (left <= right) {
            mid = (left + right) / 2;
            pivot = matrix[mid / n][mid % n];
            if (pivot == target)
                return true;
            if (pivot < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
