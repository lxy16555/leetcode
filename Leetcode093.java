public class Solution {
    //回溯法，用ip存当前读取，如果segment到4时正好读完，加入ans；如果塞segment没到4时读完，从上一个split改写为进一位，注意ip每一位大小为0~255
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12)
            return ans;
        String ip = "";
        split(0, 0, s, ans, ip);
        
        return ans;
    }
    
    public void split(int start, int segment, String s, List<String> ans, String ip) {
        if (segment == 4) {
            if (start == s.length()) {
                ip = ip.substring(0, ip.length()-1);
                ans.add(ip);
            }
            return;
        } else {
            if (start == s.length())
                return;
        }
        
        ip += s.charAt(start);
        ip += '.';
        split(start+1, segment+1, s, ans, ip);
        ip = ip.substring(0, start+segment);
        
        if (s.charAt(start) != '0') {
            if (start < s.length()-1) {
                ip += s.charAt(start);
                ip += s.charAt(start+1);
                ip += '.';
                split(start+2, segment+1, s, ans, ip);
                ip = ip.substring(0, start+segment);
            }
            
            if (start < s.length()-2) {
            int tmp = Integer.parseInt(s.substring(start, start+3));
                if (tmp <= 255) {
                    ip += s.charAt(start);
                    ip += s.charAt(start+1);
                    ip += s.charAt(start+2);
                    ip += '.';
                    split(start+3, segment+1, s, ans, ip);
                    ip = ip.substring(0, start+segment);
                }
            }
        }
        
        return;
    }
}
