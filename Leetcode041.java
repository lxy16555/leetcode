package test;

//找到第一个不连续的正数，要求O(n)时间及常量空间
public class Leetcode041 {
    public int firstMissingPositive(int[] nums) {
    	//设定常量空间
    	int[] temp = new int[nums.length];
    	
    	//初始化
    	for (int i=0; i<nums.length; i++)
    		temp[i] = 0;
    	
    	//当读到哪个正数且在有效范围内，将常量空间改为1
        for (int i=0; i<nums.length; i++)
        	if (nums[i] > 0 && nums[i] <= nums.length)
        		temp[nums[i]-1] = 1;
        
        //找到第一个不是0
        for (int i=0; i<nums.length; i++)
        	if (temp[i] == 0)
        		return i+1;
        
        //若数组长度为0或者完全连续，返回+1的正数
        return nums.length+1;
    }
}
