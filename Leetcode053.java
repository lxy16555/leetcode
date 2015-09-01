package test;

//找和最大子序列，遍历O(n)，当存储max，当temp和值小于零，重新开始
public calss Leetcode053 {
    public int maxSubArray(int[] nums) {
	//max记录最大和，temp记录当前序列是否为正
        int max = nums[0];
        int temp = 0;
        
	//循环，每次比较存max，如果遇到序列和小于零，重新开始
        for (int i=0; i<nums.length; i++) {
            temp += nums[i];
            max = max > temp ? max : temp;
            
            if (temp < 0)
                temp = 0;
        }
        
        return max;
    }
}