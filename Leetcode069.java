package test;

//��������ƽ�������㷨������binary search�ӿ��ٶ�
public class Solution {
    //�����ʼ�����0��1Ϊ�������
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        
        return calculate(0, x, x);
    }
    
    //binary search�㷨��ÿ��ƽ��x���ӷ��˷��ᳬ��integer�Ͻ죬��ȡ�����������㣬�˴�ע��ƽ��start��endʱע����ż��
    public int calculate(int start, int end, int x) {
        int mid = start/2 + end/2;
        if (start % 2 == 1 && end % 2 == 1)
            mid++;
            
        if (end - start == 1)
            return start;
        
        if (x/mid < mid)
            return calculate(start, mid, x);
        else if (x/mid == mid)
            return mid;
        else
            return calculate(mid, end, x);
    }
}