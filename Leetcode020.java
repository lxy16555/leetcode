package test;

//��Ч���Ŷ�
public class Leetcode020 {
	//�ж��Ƿ�ɶ�
	public boolean isPair(char a, char b) {
		switch (a) {
		case '(': {
			if (b == ')')
				return true;
		}
		case '[': {
			if (b == ']')
				return true;
		}
		case '{': {
			if (b == '}')
				return true;
		}
		}
		
		return false;
	}
	
	//�ж��Ƿ���Ч�ַ���
	public boolean isValid(String s) {
		//�������ַ���ȻΪ��
		if (s.length() == 0 || s.length() % 2 == 1)
			return false;
		
		//ǰ������pre,���������ɶ�������д�룬���������ɶ���������ǰ���ַ������һ���Ƚ�,���ɶ���Ϊ��
		int i = 0;
		String pre = "";
		while (i < s.length()) {
			if (i < s.length()-1 && isPair(s.charAt(i), s.charAt(i+1))) {
				i += 2;
				continue;
			}
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				pre += s.charAt(i);
				i++;
				continue;
			}
			if (pre.length() > 0 && isPair(pre.charAt(pre.length()-1), s.charAt(i))) {
				pre = pre.substring(0, pre.length()-1);
				i++;
				continue;
			} else {
				return false;
			}
		}
		
		//��ǰ���ַ����ǿգ�Ϊ�٣�����Ϊ��
		if (pre.length() == 0)
			return true;
		else
			return false;
	}
	
	public static void main(String argsp[]) {
		String s = "([])";
		
		Leetcode020 test = new Leetcode020();
		System.out.println(test.isValid(s));
	}
}
