package test;

//转换成下一个较大的数字组，若已经最大，则变成最小的
public class Leetcode031 {
	//反转函数
	public void reverse(int[] nums, int start, int end) {
		int temp;
		for (int i=0; i<=(end-start)/2; i++) {
			temp = nums[start+i];
			nums[start+i] = nums[end-i];
			nums[end-i] = temp;
		}
	}
	
	public void nextPermutation(int[] nums) {
		if (nums.length > 1) {
			int i = nums.length - 1;
			int j = nums.length - 1;
			while (i-1>=0 && nums[i] <= nums[i-1])
				i--;
			if (i == 0)
				reverse(nums, 0, nums.length-1);
			else {
				int temp = nums[i-1];
				while (nums[j] <= temp)
					j--;
				nums[i-1] = nums[j];
				nums[j] = temp;
				reverse(nums, i, nums.length-1);
			}
		}
	}
	
	public static void main(String args[]) {
		int[] nums = {3, 2, 1};
		
		Leetcode031 test = new Leetcode031();
		test.nextPermutation(nums);
		
		for (int i=0; i<nums.length; i++)
			System.out.println(nums[i]);
	}
}
