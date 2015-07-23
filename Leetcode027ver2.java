package test;

//与最后一位换位置，较快
public class Leetcode027ver2 {
	public int removeElement(int[] nums, int val) {
		int countRemove = 0;
		int length = nums.length;
		int temp;
		int i = 0;
		
		while (i + countRemove < length) {
			if (nums[i] == val) {
				temp = nums[i];
				nums[i] = nums[length-1-countRemove];
				nums[length-1-countRemove] = temp;
				countRemove++;
			} else {
				i++;
			}
		}
		
		return length - countRemove;
	}
	
	public static void main(String args[]) {
		int[] nums = {1, 1, 2, 3, 5, 2, 4, 2, 3, 7, 2, 2, 9};
		int val = 2;
		
		Leetcode027ver2 test = new Leetcode027ver2();
		int count = test.removeElement(nums, val);
		
		for (int i=0; i<count; i++)
			System.out.println(nums[i]);
	}
}
