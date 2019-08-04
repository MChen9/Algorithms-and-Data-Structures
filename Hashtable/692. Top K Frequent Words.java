class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        Map<Integer, List<String>> occurWords = new HashMap<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (!occurWords.containsKey(entry.getValue()))
                occurWords.put(entry.getValue(), new ArrayList<String>());
            occurWords.get(entry.getValue()).add(entry.getKey());
        }
        List<Map.Entry<Integer, List<String>>> list = new LinkedList(occurWords.entrySet());
        list.sort(Map.Entry.comparingByKey());
        for (Map.Entry<Integer, List<String>> entry: list) {
            Collections.sort(entry.getValue());
        }
        List<String> res = new ArrayList<>();
        int n = list.size();
        for (int i = n - 1; i >= 0; i--) {
            res.addAll(list.get(i).getValue());
        }
        return res.subList(0, k);
    }
}
