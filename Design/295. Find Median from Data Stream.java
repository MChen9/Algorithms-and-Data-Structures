class MedianFinder {
    
    Queue<Long> maxHeap, minHeap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>();
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        minHeap.offer((long) num);
        maxHeap.offer(- minHeap.poll());
        
        if (minHeap.size() < maxHeap.size())
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
