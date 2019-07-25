class MinStack {
    /**
     * Key Points:
     *   1. Use two stacks, one ordinary stack, another one stores minimun number;
     *   2. When we do push() or pop() operations, we need to compare new element
     *      with top element of min, if the top element of min is not the minimum,
     *      we need to push new element to min at the same time with ordinary push;
     *   3. When we do pop(), we need to know whether new element equals to top of 
     *      min, if yes, then we need to do pop() on min as well
     *
     * Time Complexity: O(1) for all operation
     * Space Complexity: O(n)
     *   
     */
    
    Stack<Integer> stack, min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x <= min.peek())
            min.push(x);
    }
    
    public void pop() {
        if (min.peek().equals(stack.pop())) //should not use == when using objects
            min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
