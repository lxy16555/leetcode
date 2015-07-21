package test;

//有效括号对
public class Leetcode020 {
	//判断是否成对
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
	
	//判断是否有效字符串
	public boolean isValid(String s) {
		//奇数个字符必然为假
		if (s.length() == 0 || s.length() % 2 == 1)
			return false;
		
		//前置括号pre,当遇到不成对左括号写入，当遇到不成对右括号与前置字符串最后一个比较,不成对则为假
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
		
		//若前置字符串非空，为假，否则为真
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
