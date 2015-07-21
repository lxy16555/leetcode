package test;
import java.util.*;

public class Leetcode018 {
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
	
	public List<Integer> insert(int a, int b, int c, int d) {
		List<Integer> ans = new ArrayList<Integer>(4);
		
		ans.add(a);
		ans.add(b);
		ans.add(c);
		ans.add(d);
		return ans;
	}
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		this.quicksort(nums, 0, nums.length-1);
		
		for (int i=0; i<nums.length-3; i++) {
			if (i > 0 && nums[i] == nums[i-1])
				continue;
			
			for (int j=i+1; j<nums.length-2; j++) {
				if (j > i+1 && nums[j] == nums[j-1]) {
					continue;
				}
				
				int k = j+1;
				int l = nums.length-1;
				while (k < l) {
					if (k > j+1 && nums[k] == nums[k-1]) {
						k++;
						continue;
					}
					if (l < nums.length-1 && nums[l] == nums[l+1]) {
						l--;
						continue;
					}
					if (nums[k] + nums[l] < target - nums[i] - nums[j]) {
						k++;
						continue;
					}
					if (nums[k] + nums[l] > target - nums[i] - nums[j]) {
						l--;
						continue;
					}
					if (nums[k] + nums[l] == target - nums[i] - nums[j]) {
						ans.add(insert(nums[i], nums[j], nums[k], nums[l]));
						k++;
						continue;
					}
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String args[]) {
		int[] nums = {1, 0, -1, 0, -2, 2};
		int target = 0;
		
		Leetcode018 test = new Leetcode018();
		System.out.println(test.fourSum(nums, target));
	}
}
