class Solution {
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
