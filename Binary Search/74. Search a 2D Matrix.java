class Solution {
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
