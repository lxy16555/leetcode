package test;

//�ж�������ʽ������ǰһ������Ϊ��������һ��Ϊ����������ʽ��ֻ�����ο���*��.����������Ľ�
public class Leetcode010 {
	//�ж�ab�ַ��Ƿ�һ��
	public boolean isSame(char a, char b) {
		if (b == '.')
			return true;
		if(a == b)
			return true;
		return false;
	}
	
	public boolean isMatch(String s, String p) {
		int length1 = s.length();
		int length2 = p.length();
		
		//������ʼ��
		if (length1 == 0) {
			if (length2 % 2 == 0) {
				for (int i = 1; i < length2; i = i + 2)
					if (p.charAt(i) != '*')
						return false;
				return true;
			}
			return false;
		}
		
		if (length2 == 0)
			return false;
		
		//��p��β����*ʱ
		if (p.charAt(length2-1) != '*') {
			if (isSame(s.charAt(length1-1), p.charAt(length2-1)))
				return isMatch(s.substring(0, length1-1), p.substring(0, length2-1));
			return false;
		} 
		//��p��*��βʱ
		else {
			//�������ڶ�������.ʱ
			if (p.charAt(length2-2) != '.') {
				if (isSame(s.charAt(length1-1), p.charAt(length2-2))) {
					int temp = length1;
					do {
						temp--;
						if (isMatch(s.substring(0, temp), p.substring(0, length2-2)))
							return true;
					} while (temp > 0 && s.charAt(temp-1) == s.charAt(length1-1));
				}
				return isMatch(s.substring(0, length1), p.substring(0, length2-2));
			} 
			//�������ڶ�����.ʱ
			else {
				int temp = length1;
				do {
					if (isMatch(s.substring(0, temp), p.substring(0, length2-2)))
						return true;
					temp--;
				} while (temp >= 0);
			}
		}
		
		return false;
	}
	
	//������
	public static void main(String args[]) {
		String s = "aaaaaaaaaaaaab";
		String p = "a*a*a*a*a*a*a*a*a*a*a*a*b";
		
		Leetcode010 test = new Leetcode010();
		System.out.println(test.isMatch(s, p));
	}
}
