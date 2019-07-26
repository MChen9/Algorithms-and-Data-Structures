class Solution {
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
