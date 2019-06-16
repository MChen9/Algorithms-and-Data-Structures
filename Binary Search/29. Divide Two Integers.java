class Solution {
    /**
     * [Reference](https://leetcode.com/problems/divide-two-integers/discuss/13407/C%2B%2B-bit-manipulations)
     * Key points:
     *   1. Division means how many divisor can make up a dividend,
     *      e.g. 10 = 3 + 3 + 3 + 1  -> 3 divisor and 1 remainder;
     *   2. In every case, either even number of divisors or odd number 
     *      of divisors are possible, we can use unsigned left shift
     *      to sum divisors up to remainding one or zero divisor of 
     *      dividend, e.g. 10 = 3 << 1 + 3 + 1;
     *   3. divd -= temp means subtracting even number of divisors, then
     *      subtract divisor again to have a smaller dividend, which
     *      is less than divisor;
     *   4. Cast to long to prevent overflow when dividend is INT_MIN, 
     *      we need an absolute number, which larger than INT_MAX.
     *
     * Time Complexity: O(log n), since we multiplicate 2 every time
     * Space Complexity: O(1)
     */
    public int divide(int dividend, int divisor) {
       if (dividend == Integer.MIN_VALUE && divisor == -1)
           return Integer.MAX_VALUE;
        int sign = dividend > 0 ^ divisor > 0 ? -1: 1; // ^ means XOR
            
        long divd = Math.abs((long) dividend),  // cast before abs
        divr = Math.abs((long) divisor);
        long ans = 0;
        
        while (divd >= divr) {
            long temp = divr, m = 1;
            while (temp << 1 <= divd) {
                temp <<= 1;
                m <<= 1;
            }
            divd -= temp;
            ans += m;
        }
        return (int) ans * sign;
    }
}
