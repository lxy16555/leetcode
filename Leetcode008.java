package test;

/*atoi机制明确：
 * 1.从第一个不是空格的字符算起
 * 2.如果第一个字符非数字及"-"和"+"，则返回0
 * 3.遍历直到第一个非数字字符出现，若超出int范围返回MIN或者MAX
 * @author xiliu
 */
public class Leetcode008 {
	//查找最后一位
	public int findLastNum(String str) {
		for (int i=1; i<str.length(); i++)
			if (str.charAt(i)-'0' < 0 || str.charAt(i)-'0' > 9)
				return i;
		return str.length();
	}
	
	public int myAtoi(String str) {
		//初始化，把左右的空格去除，把字符串中间的空格变成"."保证会停止
		str = str.trim();
		str = str.replace(" ", ".");
		
		//初始化，如果空字符串直接返回0
		if (str.length() == 0)
			return 0;
		
		//初始化，字符串非空则第一位为0，找到最后一位
		int first = 0;
		int last = findLastNum(str);
		int sig = 0;
		
		//若第一位是"-"或"+"则从第二位计数并同时记录正负，若第一位是非数字，则first=last
		if (str.charAt(0) == '-') {
			sig = 1;
			first++;
		} else if (str.charAt(0) == '+')
			first++;
		else if (str.charAt(first)-'0' < 0 || str.charAt(first)-'0' > 9)
			first = last;
		
		//用dig记录数字总长度
		int dig = last - first;
		
		//分类讨论，dig为0，dig大于10，dig小于10，dig等于10的情况
		if (dig == 0)
			return 0;
		else if (dig > 10) {
			if (sig == 1)
				return Integer.MIN_VALUE;
			return Integer.MAX_VALUE;
		} else if (dig < 10) {
			if (sig == 1)
				return - Integer.parseInt(str.substring(first, last));
			return Integer.parseInt(str.substring(first, last));
		} else {
			int temp1 = Integer.parseInt(str.substring(first, last-1));
			int temp2 = Integer.parseInt(str.substring(last-1, last));
			if (temp1 > 214748364) {
				if (sig == 1) return Integer.MIN_VALUE;
				return Integer.MAX_VALUE;
			} else if (temp1 == 214748364) {
				if (sig == 1) {
					if (temp2 < 9) return -temp1*10-temp2;
					return Integer.MIN_VALUE;
				} else {
					if (temp2 < 8) return temp1*10+temp2;
					return Integer.MAX_VALUE;
				}
			} else {
				if (sig == 1) return -temp1*10-temp2;
				return temp1*10+temp2;
			}
		}
	}
	
	public static void main(String args[]) {
		String str = " b11228552307";
		int ans;
		
		Leetcode008 test = new Leetcode008();
		ans = test.myAtoi(str);
		System.out.println(ans);
	}
}
