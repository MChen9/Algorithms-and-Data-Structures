class Solution {
    /**
     * Key Points:
     *   1. If there is no collision, we say it is stable, we only need to consider
     *      the rightmost one when adding new one, which is suitable for peek() of stack;
     *   2. If new one is positive, even though the top element of stack is negative, they 
     *      will not collide, so we can push it to stack safely;
     *   3. If new one is negative, we need to consider several situation
     *      3.1. We need to compare it with the top elements and pop it until we meet negative
     *           one or stack is empty or top one is larger than the new one
     *      3.2. If we meet a same mass one, then we just pop it since they will disappear together
     *      3.3. If we do not meet the same mass and the top one is negative, we just need to push
     *           new one
     *    
     * Time Complexity: O(n), since we can only push or pop n times
     * Space Complexity: O(n), for a stack
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a: asteroids) {
            if (a > 0) {
                stack.push(a);
            } else {
                while (! stack.empty() && stack.peek() > 0 && stack.peek() < -a) {
                    stack.pop();
                }
                if (! stack.empty() && stack.peek() == -a) {
                    stack.pop();
                } else if (stack.empty() || stack.peek() < 0) {
                    stack.push(a);
                }
            }
        }
        
        int[] res = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.get(i);
        }
        return res;
    }
}
