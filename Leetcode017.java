package test;
import java.util.*;

//无从下手，参考网上递归方法
public class Leetcode017 {
	//用于存储答案
	List<String> ans = new ArrayList<String>();
	
	//选择的种类，也可以数组实现
	public String change(char a) {
		switch (a) {
		case '0': return " ";
		case '2': return "abc";
		case '3': return "def";
		case '4': return "ghi";
		case '5': return "jkl";
		case '6': return "mno";
		case '7': return "pqrs";
		case '8': return "tuv";
		case '9': return "wxyz";
		}
		return "";
	}
	
	//递归式
	void formString(String digits, String temp) {
		if (digits.length() == 0)
			ans.add(temp);
		else {
			for (int i=0; i<change(digits.charAt(0)).length(); i++) {
				temp = temp + change(digits.charAt(0)).charAt(i);
				formString(digits.substring(1, digits.length()), temp);
				temp = temp.substring(0, temp.length()-1);
			}
		}
	}
	
	//清空ans并调用递归式
	public List<String> letterCombinations(String digits) {
		ans.clear();
		
		if (digits.length() == 0)
			return ans;
		
		String temp = "";
		formString(digits, temp);
		return ans;
	}
	
	//主函数
	public static void main(String args[]) {
		String digits = "23";
		
		Leetcode017 test = new Leetcode017();
		System.out.println(test.letterCombinations(digits));
	}
}
