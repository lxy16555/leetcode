package test;

//���������1���򵥣��ȸ���ϲ�����⣬Ψһע���λ
public class Leetcode066 {
    public int[] plusOne(int[] digits) {
        int temp = 1;
        int store = 0;
        
        for (int i=digits.length-1; i>=0; i--) {
            store = digits[i];
            digits[i] = (digits[i] + temp) % 10;
            temp = (store + temp) / 10;
            
            if (temp == 0)
                return digits;
        }
        
        int[] newdigits = new int[digits.length+1];
        newdigits[0] = 1;
        
        return newdigits;
    }
}