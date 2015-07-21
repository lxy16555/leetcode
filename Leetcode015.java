package test;
import java.util.*;

//���������Ϊ0���ѵ�������ʱ��
public class Leetcode015 {
	//��MERGESORT���죬�����˷ѿռ䣬QUICKSORT����ʱ��Ϊnlogn�����˷Ѷ���ռ�
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
	
	//����List����
	public List<Integer> insert(int a, int b, int c) {
		List<Integer> ans = new ArrayList<Integer>(3);
		
		ans.add(a);
		ans.add(b);
		ans.add(c);
		return ans;
	}
	
	//�������������ȷ����һ������λ�ã�����������β��ʼ�ң�ͨ���޶�����������ͬ�����List.add����ȥList.contains����ʱ��(��Ҫ��ʱ)
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		this.quicksort(nums, 0, nums.length-1);
		
		for (int i=0; i < nums.length-2; i++) {
			if (nums[i] > 0)
				break;
			
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
				if (nums[k] < 0 || nums[j] > -nums[i])
					break;
				if (nums[j] + nums[k] < -nums[i]) {
					j++;
					continue;
				}
				if (nums[j] + nums[k] > -nums[i]) {
					k--;
					continue;
				}
				if (nums[j] + nums[k] == -nums[i]) {
					ans.add(insert(nums[i], nums[j], nums[k]));
					j++;
					continue;
				}
			}
		}
		
		return ans;
	}
	
	//������
	public static void main(String argsp[]) {
		int[] nums = {0, 0, 0};
		
		Leetcode015 test = new Leetcode015();
		System.out.println(test.threeSum(nums));
	}
}
