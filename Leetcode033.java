package test;

//��֪���ǲ�����Ŀ�����⣬���hardֻ���������е�target��
public class Leetcode033 {
	public int search(int[] nums, int target) {
		for (int i=0; i < nums.length; i++) {
			if (nums[i] == target)
				return i;
		}
		return -1;
	}
}
