package test;

//һ�α�������tail��head������head��ÿ��tailλ�ÿɱ䣬�����ⷨ����ʱ��
public class Leetcode003 {
	int MAX(int x, int y) {
		return x > y ? x : y;
	}
	
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		int head = 0;
		int[] prev = new int[128];
		
		//��ʼ������洢���п����ַ�(ASCiiһ��128��)
		for (int i=0; i<128; i++)
			prev[i] = -1;
		
		//�洢ǰ�γ��ֵ�λ�ã��趨ͷ���Ϊ���һ������������
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