package test;

//ʵ�������㣬ע��˴�n��ȡֵ��������������۳���double��Χ�����
public class Leetcode050 {
    //�������
    public double myPow(double x, int n) {
        //�����������n=0ʱ����1����nС����ʱ����n��int��Сֵһ�ֽ���������ǣ�������һ��
        if (n == 0)
            return 1;
        else if (n < 0) {
            if (n == Integer.MIN_VALUE)
                return (1/x)*myPow(1/x, Integer.MAX_VALUE);
            return myPow(1/x, -n);
        }
        
        //����n��ż���������������
        if (n % 2 == 0)
            return myPow(x*x, n/2);
        else
            return x*myPow(x*x, n/2);
    }
}