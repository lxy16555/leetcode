package test;

//�����㷨��53�⣬����һ�����ε㣬�������Ҫô�����Ҫô���ұ�Ҫô���м䣬�Ƚ�����������ݹ�
public class Leetcode053ver2 {
    //���ؽϴ�ֵ
    public int max(int a, int b) {
        return a > b ? a : b;
    }
    
    public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length-1);
    }
    
    public int divide(int[] nums, int start, int end) {
	//���������start=endֱ�ӷ���һ��ֵ
        if (start == end)
            return nums[start];
        
	//������һ��ֵ��ȡ��ֹ������������Ҵ�С
        int mid = (start + end) / 2;
        int leftmax = divide(nums, start, mid);
        int rightmax = divide(nums, mid+1, end);
        
	//����ӷָ����������ֵ���
        int temp = 0;
        int left = nums[mid];
        for (int i=mid; i>=start; i--) {
            temp += nums[i];
            left = max(temp, left);
        }
        
        temp = 0;
        int right = nums[mid+1];
        for (int i=mid+1; i<=end; i++) {
            temp += nums[i];
            right = max(temp, right);
        }
        
	//�Ƚ��������ȡ���ֵ
        return max(max(leftmax, rightmax), left + right);
    }
}