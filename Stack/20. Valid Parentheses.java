class Solution {
    /**
     * Key Points:
     *   1. Use hashmap to store end of brackets as keys;
     *   2. If stack is empty when we need to pop, return false directly,
     *      if the s.charAt(i) does not equal to the top of stack, which
     *      means parentheses are not match.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        Character[] end = {')', '}', ']'};
        Character[] start = {'(', '{', '['};
        for (int i = 0; i < end.length; i++) {
            map.put(end[i], start[i]);
        }
        for (int i = 0; i < s.length(); i++) {
            if (! map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty() || map.get(s.charAt(i)) != stack.pop())
                    return false;
            }
        }
        return stack.size() == 0? true: false;
    }
}
