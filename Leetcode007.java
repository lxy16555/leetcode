package test;

//难点在int型的overflow，这里用一个取巧，overflow之后变动的值的尾数不等于temp存储的第一位
public class Leetcode007 {
	public int reverse(int x) {
		int temp = 0;
		int ans = 0;
		int sig = 0;
		
		if (x == -2147483648)
			return 0;
		
		if (x < 0) {
			x = -x;
			sig = 1;
		}
		
		while (x > 0) {
			temp = x % 10;
			ans = ans * 10 + temp;
			x = x / 10;
		}
		
		if (ans % 10 != temp)
			return 0;
		
		if (sig == 1)
			return -ans;
		else
			return ans;
	}
	
	public static void main(String args[]) {
		int x = 1534236469;
		int ans;
		
		Leetcode007 test = new Leetcode007();
		ans = test.reverse(x);
		System.out.println(ans);
	}
}
