package test;

//简单
public class Leetcode065 {
    public boolean isValid(String a) {
        boolean isDotUsed = false;
        
        int i = 0;
        while (i<a.length() && (a.charAt(i) < '0' || a.charAt(i) > '9')) {
            i++;
        }
        
        if (i == a.length())
            return false;
        
        for (int j=0; j<i-1; j++) {
            if (a.charAt(j) != '-' && a.charAt(j) != '+')
                return false;
        }
        
        if (i-1 >= 0) {
            if (a.charAt(i-1) == '.')
                isDotUsed = true;
            else if (a.charAt(i-1) != '+' && a.charAt(i-1) != '-')
                return false;
        }
        
        for (int j=i+1; j<a.length(); j++) {
            if (a.charAt(j) == '.') {
                if (isDotUsed)
                    return false;
                isDotUsed = true;
            } else if (a.charAt(j) < '0' || a.charAt(j) > '9')
                return false;
        }
        
        return true;
    }
    
    public boolean isValidInt(String a) {
        int i = 0;
        while (i<a.length() && (a.charAt(i) < '0' || a.charAt(i) > '9')) {
            i++;
        }
        
        if (i == a.length())
            return false;
        
        for (int j=0; j<i; j++) {
            if (a.charAt(j) != '-' && a.charAt(j) != '+')
                return false;
        }
        
        for (int j=i; j<a.length(); j++) {
            if (a.charAt(j) < '0' || a.charAt(j) > '9')
                return false;
        }
        
        return true;
    }
    
    public boolean isNumber(String s) {
        s = s.trim();
        
        if (s.length() == 0)
            return false;
        
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != 'e')
                continue;
            else {
                if (i == s.length()-1)
                    return false;
                if (isValid(s.substring(0, i)) && isValidInt(s.substring(i+1, s.length()))) {
                    return true;
                }
                return false;
            }
        }
        
        if (isValid(s.substring(0, s.length())))
            return true;
        return false;
    }
}