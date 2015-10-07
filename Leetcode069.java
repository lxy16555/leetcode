package test;

//给出计算平方根的算法，可用binary search加快速度
public class Solution {
    //定义初始情况，0及1为特殊情况
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        
        return calculate(0, x, x);
    }
    
    //binary search算法，每次平分x，加法乘法会超出integer上届，故取减法除法运算，此处注意平分start与end时注意奇偶性
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