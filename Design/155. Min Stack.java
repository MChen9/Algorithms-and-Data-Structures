class MinStack {
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
        if (min.peek().equals(stack.pop()))
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
