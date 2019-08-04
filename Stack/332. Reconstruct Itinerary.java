class Solution {
    /**
     * [Iterative] + [Stack] + [Priority Queue]
     * Key Points:
     *   1. Use hashmap and priority queue(insert() by logn time) to construct a graph;
     *   2. Use stack to store names and pop when there is no next stop;
     *   3. Use linkedlist to store result, which store the element to the first idx,
     *      and push current element to the right.
     *
     * Time Complexity: O(nlogn), n airports
     * Space Complexity: O(n), n airports for priority queue and stack
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> itiMap = new HashMap<>();
        for (List<String> ticket: tickets) {
            if (! itiMap.containsKey(ticket.get(0)))
                itiMap.put(ticket.get(0), new PriorityQueue<>());
            itiMap.get(ticket.get(0)).offer(ticket.get(1));
        }
        
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        List<String> res = new ArrayList<>();
        while (! stack.isEmpty()) {
            String cur = stack.peek();
            if (itiMap.get(cur) != null && itiMap.get(cur).size() > 0)
                stack.push(itiMap.get(cur).poll());
            else
                res.add(0, stack.pop());
        }
        return res;
    }
}
