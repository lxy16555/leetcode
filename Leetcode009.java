package test;

/*Ҫ��
 *1.���ö���Ŀռ�(����ʾ��ת��������)
 *2.�뵽����������Ƚϻ��߷�ת����
 *3.���з�ת���ֻ�������������⣬�������Ϊ���ܣ���Ϊ�������������������ԭ�ȵ���
 */
public class Leetcode009 {
	public boolean isPalindrome(int x) {
		int y = 0;
		int z = x;
		
		if (x < 0) x = -x;
		
		while (x > 0) {
			y = y*10 + x%10;
			x = x / 10;
		}
		
		if (y-z == 0)
			return true;
		return false;
	}
	
	public static void main(String args[]) {
		int x = 12321;
		
		Leetcode009 test = new Leetcode009();
		System.out.println(test.isPalindrome(x));
	}
}
