package test;

//比较慢的遍历法
public class Leetcode026 {
	public int removeDuplicates(int[] nums) {
		if (nums.length < 2)
			return nums.length;
		
		int count = 1;
		for (int i=1; i<nums.length; i++) {
			if (nums[i] != nums[i-1]) {
				count++;
				nums[count-1] = nums[i];
			}
		}
		
		return count;
	}
	
	public static void main(String args[]) {
		int[] nums = {1, 1, 2};
		
		Leetcode026 test = new Leetcode026();
		int count = test.removeDuplicates(nums);
		
		for (int i=0; i<count; i++)
			System.out.println(nums[i]);
	}
}
