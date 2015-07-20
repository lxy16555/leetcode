package test;

public class Leetcode013 {
	//转换规则
	public int change(char a) {
		switch (a) {
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;
		}
		return 0;
	}
	
	public int romanToInt(String s) {
		//由于输入限定为1~3999，可初始化
		int ans = change(s.charAt(s.length()-1));
		int max = change(s.charAt(s.length()-1));
		
		if (s.length() == 1)
			return ans;
		
		//若前一个数字小于后一个则减，否则加，存储最大的数
		for (int i = s.length()-1; i > 0; i--) {
			if (change(s.charAt(i-1)) < max) {
				ans = ans - change(s.charAt(i-1));
				continue;
			}
			ans = ans + change(s.charAt(i-1));
			max = change(s.charAt(i-1));
		}
		return ans;
	}
	
	//主函数
	public static void main(String args[]) {
		String s = "MMMXC";
		
		Leetcode013 test = new Leetcode013();
		System.out.println(test.romanToInt(s));
	}
}
