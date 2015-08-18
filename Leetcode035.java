package test;

//同034，寻找一个序列中小于target的个数
public class Leetcode035 {
	public int searchInsert(int[] nums, int target) {
		if (nums.length == 0)
			return 0;
		
		return partition(nums, target, 0, nums.length-1);
	}
	
	//迭代程序，返回int值
	int partition(int[] nums, int target, int start, int end) {
		if (start < end) {
			int temp = (start + end) / 2;
			if (nums[temp] < target)
				return partition(nums, target, temp+1, end);
			else if (nums[temp] > target)
				return partition(nums, target, start, temp-1);
			else if (nums[temp] == target)
				return temp;
		}
		
		if (nums[start] >= target)
			return start;
		return start+1;
	}
}
