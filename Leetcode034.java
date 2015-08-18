package test;

//已排序数列寻找某数的起点与终点，要求O(logn)时间
public class Leetcode034 {
	//定义两个index赋值
	int index1 = -1, index2 = -1;
	
	//求较小值
	int MIN(int a, int b) {
		return a < b ? a : b;
	}
	
	//求最大值
	int MAX(int a, int b) {
		return a > b ? a : b;
	}
	
	//主程序
	public int[] searchRange(int[] nums, int target) {
		divide(nums, target, 0, nums.length-1);
		int [] ans = new int[2];
		ans[0] = index1;
		ans[1] = index2;
		return ans;
	}
	
	//二分法迭代
	void divide(int[] nums, int target, int start, int end) {
		if (start <= end) {
			int temp = (start + end) / 2;
			if (nums[temp] < target)
				divide(nums, target, temp+1, end);
			if (nums[temp] > target)
				divide(nums, target, start, temp-1);
			if (nums[temp] == target) {
				if (index1 == -1 && index2 == -1) {
					index1 = temp;
					index2 = temp;
				} else {
					index1 = MIN(index1, temp);
					index2 = MAX(index2, temp);
				}
				divide(nums, target, start, temp-1);
				divide(nums, target, temp+1, end);
			}
		}
	}
}
