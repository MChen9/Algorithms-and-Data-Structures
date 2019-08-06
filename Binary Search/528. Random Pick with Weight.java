class Solution {
    /**
     * Key Points:
     *   1. Choose which item depends on its weight, so it is picking a point
     *      in [0, 1] uniformly, the intervel it falls in;
     *   2. The interval is sum(all items weights) long, we need to culmulate
     *      them, e.g. [1,2,3] -> [1, 3, 6]
     *   3. Binary search: if lo == hi, then break, if target >= array[mid], 
     *      lo = mid + 1, because we need value in the right side.
     *
     * Time Complexity: O(N) for preprocessing, O(logN) for pickIndex()
     * Space Complexity: O(N)
     */
    List<Integer> psum = new ArrayList<>();
    int tot = 0;
    Random rand = new Random();

    public Solution(int[] w) {
        for (int x : w) {
            tot += x;
            psum.add(tot);
        }
    }

    public int pickIndex() {
        int targ = rand.nextInt(tot);

        int lo = 0;
        int hi = psum.size() - 1;
        while (lo != hi) {
            int mid = (lo + hi) / 2;
            if (targ >= psum.get(mid)) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
