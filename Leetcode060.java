package test;

//���ص�k��n������������ϳ������ַ���
public class Leetcode060 {
    //���������ַ��������޶����n=9����������̫��ʱ��
    public String formString(int n, int k, int[] stack, String s) {
	//��n������1ʱbase conditionֱ�ӷ���
        if (n == 1) {
            for (int i=1; i<stack.length; i++)
                if (stack[i] == 0)
                    return s+(char)(48+i);
            return s;
        }
        
	//temp����ѭ���еĸ�����num�����ĸ�����
        int temp = 1;
        int num = 1;
        for (int i=1; i<n; i++)
            temp *= i;
        
	//Ѱ���Ǵ˻�ڼ�������дk
        while (k > num*temp)
            num++;
            
        k -= (num-1)*temp;
        
	//Ѱ���Ѳ������������Ų
        for (int i=1; i<=num; i++) {
            if (stack[i] == 1)
                num++;
        }
        
	//����stack��s������
        stack[num] = 1;
        return formString(n-1, k, stack, s+(char)(48+num));
    }
    
    public String getPermutation(int n, int k) {
        int[] stack = new int[n+1];
        for (int i=0; i<n+1; i++)
            stack[i] = 0;
        
        return formString(n, k, stack, "");
    }
}