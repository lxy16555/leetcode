package test;

//ͬ034��Ѱ��һ��������С��target�ĸ���
public class Leetcode035 {
	public int searchInsert(int[] nums, int target) {
		if (nums.length == 0)
			return 0;
		
		return partition(nums, target, 0, nums.length-1);
	}
	
	//�������򣬷���intֵ
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
