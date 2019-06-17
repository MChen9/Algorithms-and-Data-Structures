class Solution {
    /**
     * [Reference](https://leetcode.com/problems/peak-index-in-a-mountain-array/discuss/139848/C%2B%2BJavaPython-Better-than-Binary-Search)
     * Key points:
     *   Compare A[mid] with A[mid - 1] and A[mid + 1], if both are less than 
     *   A[mid], then A[mid] is the peak, else they might be on the left side
     *   or right side of peak.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int peakIndexInMountainArray(int[] A) {
        int left = 0, right = A.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (A[mid] < A[mid + 1])
                left = mid + 1;
            else if(A[mid] < A[mid - 1])
                right = mid - 1;  
            else
                return mid;
        }
        return 0;
    }
}
