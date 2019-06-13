class Solution {
    /**
     * Key points:
     *   Check whether set contains such element
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}
