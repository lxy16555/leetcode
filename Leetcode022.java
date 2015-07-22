package test;
import java.util.*;

//�Լ��ķ���:һ��һ��ȷ������λ�ã�����һ��Ϊ'('�����2,4,6λ���Բ���')'��������������ȷ����ʱ����temp
//���ϵĶ�����:�������������ţ���������Ŀ���������ţ�����������ʣ��Ϊ0����ɲ���
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
