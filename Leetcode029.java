package test;

//���ڲ����ó˳��Լ�ȡ�����㣬��һ�뷨Ϊ�Ӽ������ǻᳬ��ʱ�䣬�뵽�ݹ�2������⣬��Ҫ��������һЩ��������
public class Leetcode029 {
	//��Ϊinteger�����޾���ֵ��1�����ȫ��ת������ֵ
	public int multi(int dividend, int divisor) {
		if (dividend > divisor)
			return 0;
		if (dividend - divisor > divisor)
			return -1;
		
		int temp = divisor+divisor;
		int pre = 0;
		int ans = -1;
		while (temp >= dividend) {
			ans += ans;
			pre = temp;
			if (temp > Integer.MIN_VALUE-temp)
				temp += temp;
			else
				break;
		}
		
		return ans+multi(dividend-pre, divisor);
	}
	
	public int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		if (dividend  == 0)
			return 0;
		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (dividend > 0 && divisor > 0)
			return -multi(-dividend, -divisor);
		if (dividend > 0)
			return multi(-dividend, divisor);
		if (divisor > 0)
			return multi(dividend, -divisor);
		
		return -multi(dividend, divisor);
	}
	
	public static void main(String args[]) {
		int dividend = -2147483648;
		int divisor = 1;
		
		Leetcode029 test = new Leetcode029();
		System.out.println(test.divide(dividend, divisor));
	}
}
