package test;

//�����߶��������Ŀ
public class Leetcode038 {
	//��ʼ��String��ѭ���ݽ�
	public String countAndSay(int n) {
		String s = "1";
		for (int i=1; i<n; i++)
			s = rules(s);
		
		return s;
	}
	
	//�ݽ��淶
	public String rules(String s) {
		String ans = "";
		int i = 0;
		mainloop: while (i<s.length()) {
			if (i != s.length()-1) {
				for (int j=i+1; j<s.length(); j++) {
					if (s.charAt(j) != s.charAt(i)) {
						ans = ans + (char) (48+j-i) + s.charAt(i);
						i = j;
						continue mainloop;
					}
				}
				ans = ans + (char) (48+s.length()-i) + s.charAt(i);
				break;
			} else {
				ans = ans + '1' + s.charAt(i);
				break;
			}
		}
		return ans;
	}
}
