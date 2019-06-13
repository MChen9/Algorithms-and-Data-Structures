class Solution {
    /**
     * [Reference](https://leetcode.com/articles/group-anagrams/)
     * Key points:
     *   1. Store count of chars of string, since anagram has same count of chars;
     *   2. Convert array of chars count to string as a key for the hash map;
     *   3. If strs have same count, then add them to array list as value of map.
     *
     * Time Complexity: O(NK). N is #words, K is the length of single word
     * Space Complexity: O(NK). The total information content stored in ans.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String s: strs) {
            char[] count = new char[26];
            for (char c: s.toCharArray()) {
                count[c - 'a']++;  
            }
            String key = new String(count);
            if (! map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(s);                
        }
        
       return new ArrayList(map.values()); 
    }
}
