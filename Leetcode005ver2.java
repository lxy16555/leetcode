package test;

//两端取，选取最大的子字符串，遍历所有子字符串取最大,时间超出
public class Leetcode005ver2 {
	public String longestPalindrome(String s) {
		String ans = null;
		length: for (int length = s.length(); length > 0; length--)
			for (int i = 0; i + length <= s.length(); i++) {
				ans = s.substring(i, i+length);
				if (palindrome(ans))
					break  length;
				else
					continue;
			}
		return ans;
	}
	
	public boolean palindrome(String s) {
		for (int i = 0; i < s.length()/2; i++)
			if (s.charAt(i) != s.charAt(s.length()-1-i)) {
				return false;
			}
		return true;
	}
	
	public static void main(String args[]) {
		String s = "abcdabcddcbadcbaccccc";
		
		Leetcode005 test = new Leetcode005();
		String ans = test.longestPalindrome(s);
		System.out.println(ans);
	}
}
