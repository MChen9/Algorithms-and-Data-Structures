class Solution {
    public int divide(int dividend, int divisor) {
       if (dividend == Integer.MIN_VALUE && divisor == -1)
           return Integer.MAX_VALUE;
        int sign = dividend > 0 ^ divisor > 0 ? -1: 1;
            
        long divd = Math.abs((long) dividend), 
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
