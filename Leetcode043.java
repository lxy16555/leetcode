package test;

//两个String数字相乘，一位一位递进
public class Leetcode043 {
    public String multiply(String num1, String num2) {
    	//初始化，carry表示进位，temp存储该位置之和，ans存储结果
    	String ans = "";
    	int carry = 0;
    	int temp = 0;
    	int len1 = num1.length(), len2 = num2.length();
    	
    	//设定num1长度不大于num2
    	if (len1 > len2)
    		return multiply(num2, num1);
    	
    	//当一个string为0时不用计算，直接返回0
    	if (num1 == "0" || num2 == "0")
    		return "0";
    	
    	//从个位开始算，每位有i项相加，存进位，初始化temp，排入ans
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
    	
    	//当进位还有数，存入ans
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
