package test;

//����������Ѱ��ĳ����������յ㣬Ҫ��O(logn)ʱ��
public class Leetcode034 {
	//��������index��ֵ
	int index1 = -1, index2 = -1;
	
	//���Сֵ
	int MIN(int a, int b) {
		return a < b ? a : b;
	}
	
	//�����ֵ
	int MAX(int a, int b) {
		return a > b ? a : b;
	}
	
	//������
	public int[] searchRange(int[] nums, int target) {
		divide(nums, target, 0, nums.length-1);
		int [] ans = new int[2];
		ans[0] = index1;
		ans[1] = index2;
		return ans;
	}
	
	//���ַ�����
	void divide(int[] nums, int target, int start, int end) {
		if (start <= end) {
			int temp = (start + end) / 2;
			if (nums[temp] < target)
				divide(nums, target, temp+1, end);
			if (nums[temp] > target)
				divide(nums, target, start, temp-1);
			if (nums[temp] == target) {
				if (index1 == -1 && index2 == -1) {
					index1 = temp;
					index2 = temp;
				} else {
					index1 = MIN(index1, temp);
					index2 = MAX(index2, temp);
				}
				divide(nums, target, start, temp-1);
				divide(nums, target, temp+1, end);
			}
		}
	}
}
