package test;

//最长前缀字符串
public class Leetcode014 {
	public String longestCommonPrefix(String[] strs) {
		//初始化，空字符串组则返回无
		if (strs.length == 0)
			return "";
		
		//赋初值
		int min = strs[0].length();
		String ans = strs[0];
		
		//找最短数组并记录
		for (int i=0; i<strs.length; i++)
			if (strs[i].length() < min) {
				min = strs[i].length();
				ans = strs[i];
			}
		
		//逐一比较最短字符串的各个子字符串，注意：String的substring返回值无法比较，需要通过equals方法
		for (int i=min; i >=0; i--)
			for (int j=0; j<strs.length; j++) {
				if (!strs[j].substring(0, i).equals(ans.substring(0, i)))
					break;
				if (j == strs.length-1)
					return ans.substring(0, i);
			}
		
		return "";
	}
	
	public static void main(String args[]) {
		String[] strs = {"happy", "hat", "hac"};
		
		Leetcode014 test = new Leetcode014();
		System.out.println(test.longestCommonPrefix(strs));
	}
}
