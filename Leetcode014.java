package test;

//�ǰ׺�ַ���
public class Leetcode014 {
	public String longestCommonPrefix(String[] strs) {
		//��ʼ�������ַ������򷵻���
		if (strs.length == 0)
			return "";
		
		//����ֵ
		int min = strs[0].length();
		String ans = strs[0];
		
		//��������鲢��¼
		for (int i=0; i<strs.length; i++)
			if (strs[i].length() < min) {
				min = strs[i].length();
				ans = strs[i];
			}
		
		//��һ�Ƚ�����ַ����ĸ������ַ�����ע�⣺String��substring����ֵ�޷��Ƚϣ���Ҫͨ��equals����
		for (int i=min; i >=0; i--)
			for (int j=0; j<strs.length; j++) {
				if (!strs[j].substring(0, i).equals(ans.substring(0, i)))
					break;
				if (j == strs.length-1)
					return ans.substring(0, i);
			}
		
		return "";
	}
	
	public static void main(String args[]) {
		String[] strs = {"happy", "hat", "hac"};
		
		Leetcode014 test = new Leetcode014();
		System.out.println(test.longestCommonPrefix(strs));
	}
}
