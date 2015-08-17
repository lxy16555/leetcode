package test;

//不知道是不是题目有问题，标记hard只是找数组中的target数
public class Leetcode033 {
	public int search(int[] nums, int target) {
		for (int i=0; i < nums.length; i++) {
			if (nums[i] == target)
				return i;
		}
		return -1;
	}
}
