class Solution {
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
