class Solution {
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
