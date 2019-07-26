class Solution {
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
