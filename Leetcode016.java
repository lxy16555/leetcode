package test;

public class Leetcode016 {
	//用MERGESORT更快，但是浪费空间，QUICKSORT期望时间为nlogn，不浪费额外空间
	void quicksort(int[] A, int start, int end) {
		if (start < end) {
			int q = partition(A, start, end);
			quicksort(A, start, q-1);
			quicksort(A, q+1, end);
		}
	}
	
	int partition(int[] A, int start, int end) {
		int temp;
		int x = A[end];
		int i = start - 1;
		for(int j = start; j < end; j++) {
			if (A[j] <= x) {
				i++;
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		temp = A[i+1];
		A[i+1] = A[end];
		A[end] = temp;
		return i+1;
	}
	
	public int closer(int a, int b, int target) {
		return Math.abs(a-target) < Math.abs(b-target) ? a : b;
	}
	
	//主方法，排序后，确定第一个数的位置，在它后面首尾开始找，通过限定条件过滤相同项，缩短List.add及减去List.contains操作时间(主要耗时)
	public int threeSumClosest(int[] nums, int target) {
		int ans;
		this.quicksort(nums, 0, nums.length-1);
		
		if (nums.length < 3)
			return 0;
		else
			ans = nums[0] + nums[1] + nums[2];
		
		for (int i=0; i < nums.length-2; i++) {
			
			if (i >= 1 && nums[i] == nums[i-1])
				continue;
			
			int j = i + 1;
			int k = nums.length-1;
			while (j < k) {
				if (k < nums.length-1 && nums[k] == nums[k+1]) {
					k--;
					continue;
				}
				if (j > i+1 && nums[j] == nums[j-1]) {
					j++;
					continue;
				}
				if (nums[j] + nums[k] < target-nums[i]) {
					ans = closer(nums[i]+nums[j]+nums[k], ans, target);
					j++;
					continue;
				}
				if (nums[j] + nums[k] > target-nums[i]) {
					ans = closer(nums[i]+nums[j]+nums[k], ans, target);
					k--;
					continue;
				}
				if (nums[j] + nums[k] == target-nums[i])
					return target;
			}
		}
		
		return ans;
	}
	
	public static void main(String args[]) {
		int[] nums = {0, 1, 2};
		int target = 0;
		
		Leetcode016 test = new Leetcode016();
		System.out.println(test.threeSumClosest(nums, target));
	}
}
