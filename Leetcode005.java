package test;

//选取中位数向两边比较，运行缓慢，最好方法应该是动态规划，待定
public class Leetcode005 {
	public String longestPalindrome(String s) {
		String ans = null;
		int count = 0;
		
		if (s.length() == 1)
			return s;
		
		for (int i=0; i<s.length()-count/2; i++) {
			int j = 1;
			while (i-j >= 0 && i+j < s.length() && s.charAt(i-j) == s.charAt(i+j)) {
				j++;
			}
			if (count < 2*(j-1)+1) {
				count = 2*(j-1)+1;
				ans=s.substring(i-(j-1), i+(j-1)+1);
			}
			if (s.charAt(i) == s.charAt(i + 1)) {
				j = 1;
				while (i-j >= 0 && i+1+j < s.length() && s.charAt(i-j) == s.charAt(i+1+j)) {
					j++;
				}
				if (count < 2*j) {
					count = 2*j;
					ans = s.substring(i-(j-1), i+j+1);
				}
			}
		}
		return ans;
	}
	
	public static void main(String args[]) {
		String s = "abcdabcddcbadcbaccccc";
		
		Leetcode005 test = new Leetcode005();
		String ans = test.longestPalindrome(s);
		System.out.println(ans);
	}
}
