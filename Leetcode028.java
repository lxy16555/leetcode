package test;

//�����������
public class Leetcode028 {
	public int strStr(String haystack, String needle) {
		//��ʼ������needle��������haystack������needle����-1�����needleΪ�շ���0
		if (needle.length() > haystack.length() || !haystack.contains(needle))
			return -1;
		
		if (needle.length() == 0)
			return 0;
		
		//����λ������������ĸ����ȣ�����������򿼲��Ƿ����
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
