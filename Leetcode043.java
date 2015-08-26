package test;

//����String������ˣ�һλһλ�ݽ�
public class Leetcode043 {
    public String multiply(String num1, String num2) {
    	//��ʼ����carry��ʾ��λ��temp�洢��λ��֮�ͣ�ans�洢���
    	String ans = "";
    	int carry = 0;
    	int temp = 0;
    	int len1 = num1.length(), len2 = num2.length();
    	
    	//�趨num1���Ȳ�����num2
    	if (len1 > len2)
    		return multiply(num2, num1);
    	
    	//��һ��stringΪ0ʱ���ü��㣬ֱ�ӷ���0
    	if (num1 == "0" || num2 == "0")
    		return "0";
    	
    	//�Ӹ�λ��ʼ�㣬ÿλ��i����ӣ����λ����ʼ��temp������ans
    	for (int i=1; i<len1+len2; i++) {
    		if (i <= len1) {
    			for (int j=0; j<i; j++)
    				temp += (num1.charAt(len1-i+j) - '0') * (num2.charAt(len2-1-j) - '0');
    		} else if (i > len1 && i <= len2) {
    			for (int j=0; j<len1; j++)
    				temp += (num1.charAt(len1-1-j) - '0') * (num2.charAt(len2-i+j) - '0');
    		} else if (i > len1 && i > len2) {
    			for (int j=i-len2; j<len1; j++)
    				temp += (num1.charAt(len1-1-j) - '0') * (num2.charAt(len2-i+j) - '0');
    		}
    		
    		temp += carry;
    		ans = (char) (temp % 10 + 48) + ans;
    		carry = temp / 10;
    		temp = 0;
    	}
    	
    	//����λ������������ans
    	if (carry != 0)
    		ans = (char) (carry + 48) + ans;
    	
    	return ans;
    }
    
    public static void main(String args[]) {
    	String num1 = "9133";
    	String num2 = "0";
    	
    	Leetcode043 test = new Leetcode043();
    	System.out.println(test.multiply(num1, num2));
    }
}
