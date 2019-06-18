class MedianFinder {
    /**
     * [Reference](https://leetcode.com/problems/find-median-from-data-stream/discuss/74062/Short-simple-JavaC%2B%2BPython-O(log-n)-%2B-O(1))
     * Key points:
     *   1. Maintain two heaps, median = (minHeap.poll() - maxHeap.poll())/2,
     *      1.1. maxHeap is for storing -minHeap.poll(), which means converting
     *           smallest number to largest number, then pop the largest number
     *           with minus sign
     *      1.2. To make sure minHeap's length equals to maxHeap's, or one more
     *           larger, then use the trick as below
     *   2. Maintain two heaps so that findMedian() can take constant time
     *
     * Time Complexity: O(log n) for addNum(), O(1) for findMedian()
     * Space Complexity: O(n)
     */
    Queue<Long> maxHeap, minHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>();
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        minHeap.offer((long) num);
        maxHeap.offer(- minHeap.poll());
        
        if (minHeap.size() < maxHeap.size()) // make sure size are one more or equal
            minHeap.offer(- maxHeap.poll());
    }
    
    public double findMedian() {
        System.out.println(maxHeap.peek());
        if (minHeap.size() > maxHeap.size())
            return (double) minHeap.peek();
        return (minHeap.peek() - maxHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
