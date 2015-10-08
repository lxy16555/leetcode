package test;

//爬楼梯，DP问题
public class Solution {
    public int climbStairs(int n) {
        int[] storage = new int[n+1];
        for (int i=0; i<n+1; i++)
            storage[i] = -1;
        
        return DP(n, storage);
    }
    
    //memorization，初始条件为0和1
    public int DP(int n, int[] storage) {
        if (n >= 2) {
            if (storage[n-1] != -1 && storage[n-2] != -1)
                storage[n] = storage[n-1] + storage[n-2];
            else if (storage[n-1] == -1 && storage[n-2] != -1)
                storage[n] = DP(n-1, storage) + storage[n-2];
            else if (storage[n-1] != -1 && storage[n-2] == -1)
                storage[n] = storage[n-1] + DP(n-2, storage);
            else
                storage[n] = DP(n-1, storage) + DP(n-2, storage);
        }
        
        if (n == 0)
            storage[n] = 1;
        
        if (n == 1)
            storage[n] = 1;
        
        return storage[n];
    }
}