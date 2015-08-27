package test;

//wildcardƥ�䣬��REƥ�����ƣ�������RE����������ʱ�䣬�뷨Ϊ��*�ָ���ʽ��ÿ��ȡ����߱��ʽ
public class Leetcode044 {
	//�ж����ַ����Ƿ�ƥ��
	public boolean isSame(String a, String b) {
		for (int i=b.length()-1; i>=0; i--)
			if (b.charAt(i) != '?' && a.charAt(i) != b.charAt(i))
				return false;
		return true;
	}
	
	//�жϱ��ʽ
    public boolean isMatch(String s, String p) {
    	//��ʼ������p����Ϊ0ʱ
    	if (p.length() == 0)
    		return s.length() == 0;
    	
    	//����ʼ��Ϊ*����ȥ��һ��*ǰƥ�䲿��
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
    	
    	//��������Ϊ*����ȥ���һ��*֮��ƥ�䲿��
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
    	
    	//ͷβ���˶�Ϊ*��ÿ����ȥs�е�һ��ƥ��p�е�һ���ֵ�
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
