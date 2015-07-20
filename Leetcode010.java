package test;

//判定正则表达式，其中前一个输入为正常，后一个为包含正则表达式，只能依次考虑*和.的情况，待改进
public class Leetcode010 {
	//判断ab字符是否一致
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
		
		//迭代初始化
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
		
		//当p结尾不是*时
		if (p.charAt(length2-1) != '*') {
			if (isSame(s.charAt(length1-1), p.charAt(length2-1)))
				return isMatch(s.substring(0, length1-1), p.substring(0, length2-1));
			return false;
		} 
		//当p以*结尾时
		else {
			//当倒数第二个不是.时
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
			//当倒数第二个是.时
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
	
	//主函数
	public static void main(String args[]) {
		String s = "aaaaaaaaaaaaab";
		String p = "a*a*a*a*a*a*a*a*a*a*a*a*b";
		
		Leetcode010 test = new Leetcode010();
		System.out.println(test.isMatch(s, p));
	}
}
