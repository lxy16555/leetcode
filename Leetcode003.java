package test;

//一次遍历，定tail求head，若定head则每次tail位置可变，暴力解法超出时间
public class Leetcode003 {
	int MAX(int x, int y) {
		return x > y ? x : y;
	}
	
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		int head = 0;
		int[] prev = new int[128];
		
		//初始化数组存储所有可能字符(ASCii一共128个)
		for (int i=0; i<128; i++)
			prev[i] = -1;
		
		//存储前次出现的位置，设定头结点为其后一个，保存最大的
		for (int tail=0; tail<s.length(); tail++) {
			if (prev[s.charAt(tail)] >= head)
				head = prev[s.charAt(tail)] + 1;
			prev[s.charAt(tail)] = tail;
			max = MAX(max, tail - head + 1);
		}
		return max;
	}
	
	public static void main(String args[]) {
		String s = "dfsdfwefdc";
		
		Leetcode003 test = new Leetcode003();
		int max;
		max = test.lengthOfLongestSubstring(s);
		System.out.println(max);
	}
}