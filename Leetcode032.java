package test;

//寻找最长合适字符串，先从左遍历，左括号优先取最大；再从右遍历，右括号优先取最大。两个结果比较去较大值
public class Leetcode032 {
	public int MAX(int a, int b) {
		return a > b ? a : b;
	}
	
	public int longestValidParentheses(String s) {
		int length = s.length();
		int i = 0;
		int left = 0;
		int right = 0;
		int ans_left = 0;
		int ans_right = 0;
		int temp = 0;
		
		if (length < 2)
			return ans_left;
		
		while (i < length) {
			if (s.charAt(i) == '(')
				left++;
			else
				right++;
			
			if (left == right) {
				ans_left += left + right;
				left = 0;
				right = 0;
			}
			if (right > left) {
				left = 0;
				right = 0;
				temp = MAX(temp, ans_left);
				ans_left = 0;
			}
			i++;
		}
		ans_left = MAX(ans_left, temp);
		
		i--;
		left = 0;
		right = 0;
		temp = 0;
		
		while (i >= 0) {
			if (s.charAt(i) == '(')
				left++;
			else
				right++;
			
			if (left == right) {
				ans_right += left + right;
				left = 0;
				right = 0;
			}
			if (right < left) {
				left = 0;
				right = 0;
				temp = MAX(temp, ans_right);
				ans_right = 0;
			}
			i--;
		}
		ans_right = MAX(ans_right, temp);
		
		return MAX(ans_left, ans_right);
	}
	
	public static void main(String args[]) {
		String s = "(()";
		
		Leetcode032 test = new Leetcode032();
		System.out.println(test.longestValidParentheses(s));
	}
}
