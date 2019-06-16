class Solution {
    public int findDuplicate(int[] nums) {
        int p1 = 0, p2 = 0;
        do {
            p1 = nums[p1];
            p2 = nums[nums[p2]];
        } while (p1 != p2);
        
        p1 = 0;
        while (nums[p1] != nums[p2]) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return nums[p1];
    }
}
