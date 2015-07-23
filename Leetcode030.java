package test;

import java.util.ArrayList;
import java.util.List;

//方法待改进，时间介于一个好方法一个坏方法之间
public class Leetcode030 {
	//判断是否含有，用temp记录第一个index，用record记录是否出现过
	public boolean isConcatenate(String s, String[] words) {
		int singleLength = words[0].length();
		int temp;
		int[] record = new int[words.length];
		
		for (int i=0; i<words.length; i++)
			record[i] = 1;
		
		for (int i=0; i<words.length; i++) {
			temp = s.indexOf(words[i]);
			if (temp == -1)
				return false;
			else if (temp % singleLength == 0 && record[temp/singleLength] == 1) {
				record[temp/singleLength] = 0;
				continue;
			} else {
				while (temp != -1) {
					temp = s.indexOf(words[i], temp+1);
					if (temp == -1)
						return false;
					if (temp % singleLength == 0) {
						if (record[temp/singleLength] == 0)
							continue;
						else {
							record[temp/singleLength] = 0;
							break;
						}
					}
				}
			}
		}
		
		return true;
	}
	
	//初始化，并且从第一个开始移位，判断是否符合，若符合返回首目录并继续
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ans = new ArrayList<Integer>();
		if (words.length == 0 || words[0].length() == 0) {
			return ans;
		}
		
		int length = words.length * words[0].length();
		
		for (int i=0; i<=s.length()-length; i++)
			if (isConcatenate(s.substring(i, i+length), words))
				ans.add(i);
		return ans;
	}
	
	public static void main(String args[]) {
		String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] words = {"fooo", "barr", "wing", "ding", "wing"};
		
		Leetcode030 test = new Leetcode030();
		System.out.println(test.findSubstring(s, words));
	}
}
