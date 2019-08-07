class Solution {
    /**
     * [Hash Table] + [Heap]
     * Key Points:
     *   1. Use hashmap to record #occur, which is a counter;
     *   2. Use Heap to pop the min element, which is defined by Comparator
     *      2.1. We need to override compare(object, object) in Comparator
     *      2.2. Since the inputs are object, we need to use compareTo or 
     *           equals
     *
     * Time Complexity: O(NlogK), K is the #elements in heap, N is the #operation we need
     * Space Complexity: O(N)
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                Integer valueA = counter.get(a);
                Integer valueB = counter.get(b);
                return valueA.compareTo(valueB);
            }
        });
        for (int key: counter.keySet()) {
            queue.offer(key);
            if (queue.size() > k)
                queue.poll();
        }
        
        List<Integer> res = new LinkedList<>();
        while (! queue.isEmpty()) {
            res.add(queue.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
