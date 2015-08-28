package test;

//实现幂运算，注意此处n的取值，另此题无需讨论超过double范围的情况
public class Leetcode050 {
    //迭代完成
    public double myPow(double x, int n) {
        //基本情况，当n=0时返回1；当n小于零时，若n是int最小值一种解决，若不是，返回另一个
        if (n == 0)
            return 1;
        else if (n < 0) {
            if (n == Integer.MIN_VALUE)
                return (1/x)*myPow(1/x, Integer.MAX_VALUE);
            return myPow(1/x, -n);
        }
        
        //讨论n是偶数或者奇数的情况
        if (n % 2 == 0)
            return myPow(x*x, n/2);
        else
            return x*myPow(x*x, n/2);
    }
}