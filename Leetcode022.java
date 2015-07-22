package test;
import java.util.*;

//自己的方法:一个一个确定括号位置，当第一个为'('，则第2,4,6位可以插入')'，但是这样不能确定何时插入temp
//网上的二叉树:从左到右增加括号，左括号数目多于右括号，当左右括号剩余为0，则可插入
public class Leetcode022 {
	List<String> ans = new ArrayList<String>();
	
	public void generate(int left, int right, String temp) {
		if (left == 0 && right == 0)
			ans.add(temp);
		
		if (left > 0)
			generate(left-1, right, temp + '(');
		
		if (right > 0 && left < right)
			generate(left, right-1, temp + ')');
	}
	
	public List<String> generateParenthesis(int n) {
		ans.clear();
		String temp = "";
		
		generate(n, n, temp);
		return ans;
	}
	
	public static void main(String args[]) {
		int n = 3;
		
		Leetcode022 test = new Leetcode022();
		System.out.println(test.generateParenthesis(n));
	}
}
