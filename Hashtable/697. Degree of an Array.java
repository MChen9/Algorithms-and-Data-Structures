class Solution {
    /**
     * Key Points:
     *   1. Create a hashmap {num: [#occur, start, end]}, and update #occur and end within
     *      a loop;
     *   2. For loop to find the max #occur, and another for loop to find the max length.
     *
     * Time Complexity: O(n), 3 passes
     * Space Complexity: O(n)
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[2] = i;
                map.get(nums[i])[0] += 1;
            } else {
                map.put(nums[i], new int[] {1, i, i});
            }
        }
        int maxFreq = Integer.MIN_VALUE, minLen = Integer.MAX_VALUE;
        for (int[] array: map.values()) {
            maxFreq = Math.max(maxFreq, array[0]);
        }
        for (int[] array: map.values()) {
            if (array[0] == maxFreq)
                minLen = Math.min(minLen, array[2] - array[1] + 1);
        }
        return minLen;
    }
}
