package test;

//分治算法解53题，对于一个分治点，最大序列要么在左边要么在右边要么在中间，比较三种情况，递归
public class Leetcode053ver2 {
    //返回较大值
    public int max(int a, int b) {
        return a > b ? a : b;
    }
    
    public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length-1);
    }
    
    public int divide(int[] nums, int start, int end) {
	//基础情况，start=end直接返回一个值
        if (start == end)
            return nums[start];
        
	//当大于一个值，取终止，迭代算出左右大小
        int mid = (start + end) / 2;
        int leftmax = divide(nums, start, mid);
        int rightmax = divide(nums, mid+1, end);
        
	//算出从分割点的左右最大值相加
        int temp = 0;
        int left = nums[mid];
        for (int i=mid; i>=start; i--) {
            temp += nums[i];
            left = max(temp, left);
        }
        
        temp = 0;
        int right = nums[mid+1];
        for (int i=mid+1; i<=end; i++) {
            temp += nums[i];
            right = max(temp, right);
        }
        
	//比较三种情况取最大值
        return max(max(leftmax, rightmax), left + right);
    }
}