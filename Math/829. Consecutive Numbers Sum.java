class Solution {
    /**
     * Key Points:
     *   n + (n+1) + (n+2) + ... + (n+m-1)  =>  (2n + m - 1) * m / 2 = N
     *   =>  (2n + m - 1) * m = 2N 
     *   Since n > 0 and m > 0, we have 2n + m - 1 >= m
     *   =>  (2n + m - 1) * m >= m^2  => m^2 <= 2N  => m <= sqrt(2N)
     *   Besides, 2n = 2N / m - m + 1
     *   We have (2N / m - m + 1) must be an integer, so 
     *   (2N / m - m + 1) % 2 == 0
     *
     * Time Complexity: O(sqrt(n)), m <= sqrt(2N)
     * Space Complexity: O(1)
     */
    public int consecutiveNumbersSum(int N) {
        int res = 0;
        for (int m = 1; m <= Math.sqrt(2 * N); ++m) {
            double y = 2 * N/((double) m) - m  + 1;
            if (y % 2 == 0 && y > 0) {
                res++;
            }
        }
        return res;
    }
}
