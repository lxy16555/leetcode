package test;

//wildcard匹配，与RE匹配类似，但若用RE方法，超出时间，想法为以*分割表达式，每次取最左边表达式
public class Leetcode044 {
	//判断两字符串是否匹配
	public boolean isSame(String a, String b) {
		for (int i=b.length()-1; i>=0; i--)
			if (b.charAt(i) != '?' && a.charAt(i) != b.charAt(i))
				return false;
		return true;
	}
	
	//判断表达式
    public boolean isMatch(String s, String p) {
    	//初始化。当p长度为0时
    	if (p.length() == 0)
    		return s.length() == 0;
    	
    	//当起始不为*，消去第一个*前匹配部分
    	if (p.charAt(0) != '*') {
    		int temp = 0;
    		while (temp < p.length() && p.charAt(temp) != '*')
    			temp++;
    		
    		if (temp > s.length())
    			return false;
    		
    		if (isSame(s.substring(0, temp), p.substring(0, temp)))
    			return isMatch(s.substring(temp, s.length()), p.substring(temp, p.length()));
    		return false;
    	}
    	
    	//当结束不为*，消去最后一个*之后匹配部分
    	if (p.charAt(p.length()-1) != '*') {
    		int temp = p.length()-1;
    		while (temp >= 0 && p.charAt(temp) != '*')
    			temp--;
    		
    		if (p.length()-1-temp > s.length())
    			return false;
    		
    		if (isSame(s.substring(s.length()-p.length()+temp+1, s.length()), 
    				p.substring(temp+1, p.length())))
    			return isMatch(s.substring(0, s.length()-p.length()+temp+1), 
    					p.substring(0, temp+1));
    		return false;
    	}
    	
    	//头尾两端都为*，每次消去s中第一个匹配p中第一部分的
    	int start = 0;
    	while (start < p.length() && p.charAt(start) == '*')
    		start++;
    	
    	int end = start;
    	while (end < p.length() && p.charAt(end) != '*')
    		end++;
    	
    	int len = end - start;
    	
    	if (len == 0)
    		return true;
    	
    	for (int i=0; i<=s.length()-len; i++)
    		if (isSame(s.substring(i, i+len), p.substring(start, end)))
    			return isMatch(s.substring(i+len, s.length()), p.substring(end, p.length()));
    	
    	return false;
    }
}
