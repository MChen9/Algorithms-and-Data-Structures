class Solution {
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
