class Solution {
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
