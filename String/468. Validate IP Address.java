class Solution {
    /**
     * Key Points:
     * 1. IPv4
     *    1.1. "//.", since "." is a special symbol like Intege.valueOf(), when we 
     *         need pattern match, we use "//.", when we compare, we use '.'
     *    1.2. If "." appears at the beginning or the end, then there is no 
     *         tokens available before or after them
     *    1.3. We can use Integer.valueOf() to check the valid of decimal
     *    1.4. Token between every "." can only be less than 3 digits
     *    1.5. No leading zero and no more than one zero if the token is zero
     *    1.6. If it has leading zero, then #digits does not equal to actual
     *         number digits, noted that number less than 10 and 100
     * 2. IPv6
     *    2.1. If the character is not digit, then we need to make sure it is
     *         within ['A', 'F'], but noted that 'd' > 'F', we need to use 
     *         Character.toUpperCse() to make sure they are all uppercase
     *
     * Time Complexity: O(n), n is the number of char, since we know IPv6 must be 
     * less than 4 digits in every token, so the inner for loop only take O(1) time
     * Space Complexity: O(n), array to store strings
     */
    private boolean validIPv4(String IP) {
        if (IP.charAt(0) == '.' || IP.charAt(IP.length() -1) == '.') return false;
        String[] IPs = IP.split("\\.");
        if (IPs.length != 4) return false;
        for (int i = 0; i < IPs.length; i++) {
            String temp = IPs[i];
            int num = -1;
            try {
                num = Integer.valueOf(temp, 10);
            } catch(NumberFormatException ne) {
                return false;
            }
            
            if (temp.length() > 3 ||
               (num == 0 && temp.length() > 1) ||
               num > 255 || num < 0 ||
               (temp.length() > 1 && num < 10) ||
               (temp.length() > 2 && num < 100))
                return false;
        }
        return true;
    }
    
    private boolean validIPv6(String IP) {
        if (IP.charAt(0) == ':' || IP.charAt(IP.length() -1) == ':') return false;
        String[] IPs = IP.split(":");
        
        if (IPs.length != 8) return false;
        
        for (int i = 0; i < 8; i++) {
            String temp = IPs[i];
            
            for (int j = 0; j < temp.length(); j++) {
                if (!Character.isDigit(temp.charAt(j)) && 
                    (Character.toUpperCase(temp.charAt(j)) > 'F' || 
                     Character.toUpperCase(temp.charAt(j)) < 'A'))
                    return false;
            }
            
            if (temp.length() > 4 || temp.length() < 1)
                return false;
            
        }
        return true;
    }
    
    public String validIPAddress(String IP) {
        for (int i = 0; i < IP.length(); i++) {
            
            if (IP.charAt(i) == '.' && validIPv4(IP))
                return "IPv4";
            if (IP.charAt(i) == ':' && validIPv6(IP))
                return "IPv6";
        }
        return "Neither";
    }
}
