package test;

/*要求：
 *1.不用多余的空间(即表示别转化成数组)
 *2.想到方法：逐个比较或者反转数字
 *3.其中反转数字会遇到溢出的问题，解决方案为不管，因为数据溢出后往往不会变成原先的数
 */
public class Leetcode009 {
	public boolean isPalindrome(int x) {
		int y = 0;
		int z = x;
		
		if (x < 0) x = -x;
		
		while (x > 0) {
			y = y*10 + x%10;
			x = x / 10;
		}
		
		if (y-z == 0)
			return true;
		return false;
	}
	
	public static void main(String args[]) {
		int x = 12321;
		
		Leetcode009 test = new Leetcode009();
		System.out.println(test.isPalindrome(x));
	}
}
