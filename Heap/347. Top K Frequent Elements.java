class Solution {
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
