package test;

//ת�������֣��ҹ���
public class Leetcode012 {
	//�涨��������ת������num��ʾ0~9��i��ʾ������ŵ�0�ĸ���
	public String change(int num, int i) {
		if (num == 0)
			return "";
		String a = "";
		String b = "";
		String c = "";
		
		switch (i) {
		case 0: {
			a = "I";
			b = "V";
			c = "X";
			break;
		}
		case 1: {
			a = "X";
			b = "L";
			c = "C";
			break;
		}
		case 2: {
			a = "C";
			b = "D";
			c = "M";
			break;
		}
		case 3: {
			a = "M";
			b = "";
			c = "";
			break;
		}
		}
		
		switch (num) {
		case 1: return a;
		case 2: return a + a;
		case 3: return a + a + a;
		case 4: return a + b;
		case 5: return b;
		case 6: return b + a;
		case 7: return b + a + a;
		case 8: return b + a + a + a;
		case 9: return a + c;
		}
		
		return "";
	}
	
	public String intToRoman(int num) {
		int i = 0;
		String ans = "";
		
		while (num > 0) {
			ans = change(num%10, i) + ans;
			num = num / 10;
			i++;
		}
		return ans;
	}
	
	public static void main(String args[]) {
		int num = 3999;
		
		Leetcode012 test = new Leetcode012();
		System.out.println(test.intToRoman(num));
	}
}
