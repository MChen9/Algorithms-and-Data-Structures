class Solution {
    /**
     * Key points:
     *   Store all jewels in hash set, then check whether stones are jewels.
     *
     * Time Complexity: O(J.length+S.length).
     * Space Complexity: O(J.length).
     */
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        int cnt = 0;
        
        for (char j: J.toCharArray()) {
            set.add(j);
        }
        
        for (char s: S.toCharArray()) {
            if (set.contains(s))
                cnt++;
        }
        return cnt;
    }
}

