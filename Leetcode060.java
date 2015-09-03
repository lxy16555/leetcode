package test;

//返回第k个n个数字排列组合出来的字符串
public class Leetcode060 {
    //迭代加入字符，由于限定最多n=9，迭代不会太耗时间
    public String formString(int n, int k, int[] stack, String s) {
	//当n迭代到1时base condition直接返回
        if (n == 1) {
            for (int i=1; i<stack.length; i++)
                if (stack[i] == 0)
                    return s+(char)(48+i);
            return s;
        }
        
	//temp计算循环中的个数，num计是哪个数字
        int temp = 1;
        int num = 1;
        for (int i=1; i<n; i++)
            temp *= i;
        
	//寻找是此会第几个，改写k
        while (k > num*temp)
            num++;
            
        k -= (num-1)*temp;
        
	//寻找已插入的数，往后挪
        for (int i=1; i<=num; i++) {
            if (stack[i] == 1)
                num++;
        }
        
	//更新stack和s并返回
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