package test;

/*atoi������ȷ��
 * 1.�ӵ�һ�����ǿո���ַ�����
 * 2.�����һ���ַ������ּ�"-"��"+"���򷵻�0
 * 3.����ֱ����һ���������ַ����֣�������int��Χ����MIN����MAX
 * @author xiliu
 */
public class Leetcode008 {
	//�������һλ
	public int findLastNum(String str) {
		for (int i=1; i<str.length(); i++)
			if (str.charAt(i)-'0' < 0 || str.charAt(i)-'0' > 9)
				return i;
		return str.length();
	}
	
	public int myAtoi(String str) {
		//��ʼ���������ҵĿո�ȥ�������ַ����м�Ŀո���"."��֤��ֹͣ
		str = str.trim();
		str = str.replace(" ", ".");
		
		//��ʼ����������ַ���ֱ�ӷ���0
		if (str.length() == 0)
			return 0;
		
		//��ʼ�����ַ����ǿ����һλΪ0���ҵ����һλ
		int first = 0;
		int last = findLastNum(str);
		int sig = 0;
		
		//����һλ��"-"��"+"��ӵڶ�λ������ͬʱ��¼����������һλ�Ƿ����֣���first=last
		if (str.charAt(0) == '-') {
			sig = 1;
			first++;
		} else if (str.charAt(0) == '+')
			first++;
		else if (str.charAt(first)-'0' < 0 || str.charAt(first)-'0' > 9)
			first = last;
		
		//��dig��¼�����ܳ���
		int dig = last - first;
		
		//�������ۣ�digΪ0��dig����10��digС��10��dig����10�����
		if (dig == 0)
			return 0;
		else if (dig > 10) {
			if (sig == 1)
				return Integer.MIN_VALUE;
			return Integer.MAX_VALUE;
		} else if (dig < 10) {
			if (sig == 1)
				return - Integer.parseInt(str.substring(first, last));
			return Integer.parseInt(str.substring(first, last));
		} else {
			int temp1 = Integer.parseInt(str.substring(first, last-1));
			int temp2 = Integer.parseInt(str.substring(last-1, last));
			if (temp1 > 214748364) {
				if (sig == 1) return Integer.MIN_VALUE;
				return Integer.MAX_VALUE;
			} else if (temp1 == 214748364) {
				if (sig == 1) {
					if (temp2 < 9) return -temp1*10-temp2;
					return Integer.MIN_VALUE;
				} else {
					if (temp2 < 8) return temp1*10+temp2;
					return Integer.MAX_VALUE;
				}
			} else {
				if (sig == 1) return -temp1*10-temp2;
				return temp1*10+temp2;
			}
		}
	}
	
	public static void main(String args[]) {
		String str = " b11228552307";
		int ans;
		
		Leetcode008 test = new Leetcode008();
		ans = test.myAtoi(str);
		System.out.println(ans);
	}
}
