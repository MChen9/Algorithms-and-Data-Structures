class Solution {
    /**
     * Key Points:
     *   Use two stacks to store count numbers and cumulated strings
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> count = new Stack<>();
        Stack<String> chars = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int cnt = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    cnt = cnt * 10 + (s.charAt(idx) - '0');
                    idx++;
                } 
                count.push(cnt);
            } else if (s.charAt(idx) == '[') {
                chars.push(res);
                idx++;
                res = "";
            } else if (s.charAt(idx) == ']') {
                StringBuilder sb = new StringBuilder(chars.pop());
                int t = count.pop();
                for (int i = 0; i < t; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                idx++;
            } else {
                res += s.charAt(idx);
                idx++;
            }
            
        }
        return res;
    }
}
