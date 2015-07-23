package test;

//多种情况讨论
public class Leetcode028 {
	public int strStr(String haystack, String needle) {
		//初始化，若needle更长或者haystack不包含needle返回-1，如果needle为空返回0
		if (needle.length() > haystack.length() || !haystack.contains(needle))
			return -1;
		
		if (needle.length() == 0)
			return 0;
		
		//从首位遍历，若首字母不相等，则继续，否则考察是否包含
		for (int i=0; i<=haystack.length()-needle.length(); i++) {
			if (haystack.charAt(i) != needle.charAt(0))
				continue;
			if (haystack.substring(i, i+needle.length()).equals(needle))
				return i;
		}
		
		return -1;
	}
	
	public static void main(String args[]) {
		String haystack = "giveyousomecolorsese";
		String needle = "give";
		
		Leetcode028 test = new Leetcode028();
		System.out.println(test.strStr(haystack, needle));
	}
}
