package test;

//简单题，两个2进制string相加
public class Leetcode067 {
    public String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;
        if (m < n)
            return addBinary(b, a);
        
        if (n == -1) {
            if (m == -1)
                return "0";
            else
                return a;
        }
        
        int count = 0;
        String c = "";
        while (m>=0 && n>=0) {
            if (a.charAt(m) == '1' && b.charAt(n) == '1') {
                if (count == 0)
                    c = '0' + c;
                else
                    c = '1' + c;
                count = 1;
            } else if (a.charAt(m) == '1' || b.charAt(n) == '1') {
                if (count == 0) {
                    c = '1' + c;
                    count = 0;
                } else {
                    c = '0' + c;
                    count = 1;
                }
            } else {
                if (count == 0)
                    c = '0' + c;
                else
                    c = '1' + c;
                count = 0;
            }
            
            m--;
            n--;
        }
        
        while (m >= 0) {
            if (count == 1) {
                if (a.charAt(m) == '1') {
                    c = '0' + c;
                    count = 1;
                } else {
                    c = '1' + c;
                    count = 0;
                }
            } else {
                c = a.charAt(m) + c;
            }
            
            m--;
        }
        
        if (count == 1)
            c = '1' + c;
        
        return c;
    }
}